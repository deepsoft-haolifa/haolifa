package com.deepsoft.haolifa;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.model.dto.FileUploadDTO;
import com.deepsoft.haolifa.model.dto.order.OrderProductDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.util.Base64Utils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class OrderProductServiceTest extends BaseApplicationTests {

    @Autowired
    private OrderProductService orderService;

    @Test
    public void uploadOrderExcelTest() {
        String fileBase64Str = Base64Utils.encryptToBase64("d:\\123.xlsx");
        FileUploadDTO fileUploadDTO=new FileUploadDTO();
        fileUploadDTO.setBase64Source(fileBase64Str);
        fileUploadDTO.setFileName("HX1812029-X417-H-ST.xlsx");
        ResultBean resultBean = orderService.uploadOrderProduct(fileUploadDTO);
    }
}
