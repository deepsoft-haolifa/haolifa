package com.deepsoft.haolifa;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.model.domain.SysDepartment;
import com.deepsoft.haolifa.model.domain.SysDepartmentExample;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.MaterialRequestDTO;
import com.deepsoft.haolifa.model.dto.sys.DepartmentTree;
import com.deepsoft.haolifa.service.DemoService;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.util.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: DemoServiceTest
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2018-07-10 17:08
 **/
public class DemoServiceTest extends BaseApplicationTests {

    @Resource
    private DemoService demoService;

    @Test
    public void test() {
        List<SysUser> list = demoService.list();
        System.out.println("123456");
    }

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Test
    public void testtree() {
        List<SysDepartment> sysDepartments = sysDepartmentMapper.selectByExample(new SysDepartmentExample());

        ;
        List<DepartmentTree> departmentTrees = new ArrayList<>();
        sysDepartments.stream().forEach(e -> {
            DepartmentTree departmentTree = new DepartmentTree();
            departmentTree.setId(String.valueOf(e.getId()));
            departmentTree.setName(e.getDeptName());
            departmentTree.setParentId(String.valueOf(e.getPid()));
            departmentTrees.add(departmentTree);

        });
        List<DepartmentTree> treeList = TreeUtils.getTreeList("0", departmentTrees);
        System.out.println(JSONObject.toJSONString(treeList));
    }

    @Autowired
    private MaterialService materialService;


    @Test
    public void uploadMatierialExcel() {
        String path = "d://111.xlsx";
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            //获取工作薄
            Workbook wb = null;
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            }
            //读取第一个工作页sheet
            Sheet sheet = wb.getSheetAt(3);
            //第一行为标题
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                MaterialRequestDTO materialRequestDTO = new MaterialRequestDTO();
                Cell cell0 = row.getCell(0);
                String name = getCellValue(cell0);
                materialRequestDTO.setName(name);
                Cell cell1 = row.getCell(1);
                String classifyName = getCellValue(cell1);
                int clasifyId = 0;
                if (classifyName.equals("阀体")) {
                    clasifyId = 1;
                } else if (classifyName.equals("阀板")) {
                    clasifyId = 2;

                } else if (classifyName.equals("阀座")) {
                    clasifyId = 3;

                } else if (classifyName.equals("阀杆")) {
                    clasifyId = 4;

                } else if (classifyName.equals("通用零件")) {
                    clasifyId = 5;

                } else if (classifyName.equals("驱动")) {
                    clasifyId = 6;
                }
                materialRequestDTO.setMaterialClassifyName(classifyName);
                materialRequestDTO.setMaterialClassifyId(clasifyId);
                Cell cell2 = row.getCell(2);
                materialRequestDTO.setGraphNo(getCellValue(cell2));
                // 可替换料
                Cell cell3 = row.getCell(3);
                materialRequestDTO.setReplaceGraphNos(getCellValue(cell3));
                // 型号
                Cell cell4 = row.getCell(4);
                materialRequestDTO.setModel(getCellValue(cell4));
                // 规格
                Cell cell5 = row.getCell(5);
                materialRequestDTO.setSpecifications(getCellValue(cell5));
                // 配套基数
                Cell cell6 = row.getCell(6);
                int support = 1;
                if (StringUtils.isNotBlank(getCellValue(cell6))) {
                    support = Integer.valueOf(getCellValue(cell6));
                }
                materialRequestDTO.setSupportQuantity(support);
                // 安全库存
                Cell cell8 = row.getCell(8);
                int safeCount = 0;
                if (StringUtils.isNotBlank(getCellValue(cell8))) {
                    safeCount = Integer.valueOf(getCellValue(cell8));
                }
                materialRequestDTO.setSafeQuantity(safeCount);
                // 实际单重
                Cell cell10 = row.getCell(10);
                materialRequestDTO.setActualWeight(getCellValue(cell10));
                // 单价
                Cell cell12 = row.getCell(12);
                materialRequestDTO.setPrice(new BigDecimal(getCellValue(cell12)));
                // 材料
                Cell cell14 = row.getCell(14);
                materialRequestDTO.setMaterial(getCellValue(cell14));
                materialRequestDTO.setCurrentQuantity(1000);
                System.out.println(materialRequestDTO.getGraphNo());
                materialService.save(materialRequestDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        materialService.save(materialRequestDTO);
    }

    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            CellType cellTypeEnum = cell.getCellTypeEnum();
            switch (cellTypeEnum) {
                case STRING:
                    cellValue = cell.getStringCellValue();
//                    String stringCellValue = cell.getStringCellValue();
//                    boolean number = NumberUtils.isNumber(stringCellValue);
//                    cellValue = number ? new Double(stringCellValue).toString() : stringCellValue;
//                    boolean digits = NumberUtils.isDigits(stringCellValue);
//                    cellValue = digits ? stringCellValue : cellValue;
                    break;
                case NUMERIC:
                    cellValue = new BigDecimal(cell.getNumericCellValue()).toString();
                    if (cellValue.contains(".")) {
                        cellValue = Double.toString(cell.getNumericCellValue());
                    }
                    break;
                default:
                    break;
            }
        }
        return cellValue;
    }
}
