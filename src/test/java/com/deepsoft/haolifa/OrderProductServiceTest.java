package com.deepsoft.haolifa;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.dao.repository.SysRoleMapper;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.domain.SysRoleExample;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.FileUploadDTO;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import com.deepsoft.haolifa.model.dto.order.OrderProductDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.Base64Utils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.*;
import java.util.List;


public class OrderProductServiceTest extends BaseApplicationTests {

    @Autowired
    private OrderProductService orderService;

    @Test
    public void uploadOrderExcelTest() {
        String fileBase64Str = Base64Utils.encryptToBase64("d:\\123.xlsx");
        FileUploadDTO fileUploadDTO = new FileUploadDTO();
        fileUploadDTO.setBase64Source(fileBase64Str);
        fileUploadDTO.setFileName("HX1812029-X417-H-ST.xlsx");
        ResultBean resultBean = orderService.uploadOrderProduct(fileUploadDTO);
    }

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("d://user.csv")));
        String line = null;
        while (null != (line = bufferedReader.readLine())) {
            String[] split = line.split(",");
            String name = split[0];
            SysUser sysUser = new SysUser() {{
                setPassword(passwordEncoder.encode("123456"));
                setRealName(name);
                setUsername(split[1]);
            }};
            int insert = sysUserMapper.insertSelective(sysUser);
            Integer id = sysUser.getId();
            List<SysRole> sysRoles = sysRoleMapper.selectByExample(new SysRoleExample() {{
                or().andDescriptionEqualTo(name);
            }});
            SysRole sysRole = sysRoles.get(0);
            sysUserService.insertUserRole(id, new Integer[]{sysRole.getId()});
        }

    }

}
