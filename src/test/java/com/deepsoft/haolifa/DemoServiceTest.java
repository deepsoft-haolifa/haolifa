package com.deepsoft.haolifa;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.model.domain.PriceMaterial;
import com.deepsoft.haolifa.model.domain.SysDepartment;
import com.deepsoft.haolifa.model.domain.SysDepartmentExample;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.MaterialRequestDTO;
import com.deepsoft.haolifa.model.dto.sys.DepartmentTree;
import com.deepsoft.haolifa.service.DemoService;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.PriceMaterialService;
import com.deepsoft.haolifa.service.StockService;
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
    @Autowired
    private StockService stockService;
    @Autowired
    private PriceMaterialService priceMaterialService;

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
            Sheet sheet = wb.getSheetAt(0);
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
                String graphNo=getCellValue(cell2);
                materialRequestDTO.setGraphNo(graphNo);
                // 可替换料
                Cell cell3 = row.getCell(3);
                materialRequestDTO.setReplaceGraphNos(getCellValue(cell3));
                // 型号
                Cell cell4 = row.getCell(4);
                String model = getCellValue(cell4);
                materialRequestDTO.setModel(model);
                // 规格
                Cell cell5 = row.getCell(5);
                String spec = getCellValue(cell5);
                materialRequestDTO.setSpecifications(spec);
                // 配套基数
                Cell cell6 = row.getCell(6);
                int support = 1;
                if (StringUtils.isNotBlank(getCellValue(cell6))) {
                    support = Integer.valueOf(getCellValue(cell6));
                }
                materialRequestDTO.setSupportQuantity(support);
                // 期初库存
                Cell cell8 = row.getCell(8);
                int currentQuantity = 0;
                if (StringUtils.isNotBlank(getCellValue(cell8))) {
                    currentQuantity = Integer.valueOf(getCellValue(cell8));
                }
                materialRequestDTO.setCurrentQuantity(currentQuantity);
                // 安全库存
                Cell cell9= row.getCell(9);
                int safeCount = 0;
                if (StringUtils.isNotBlank(getCellValue(cell9))) {
                    safeCount = Integer.valueOf(getCellValue(cell9));
                }
                materialRequestDTO.setSafeQuantity(safeCount);
                // 所在库房
                Cell cell11 = row.getCell(11);
                String roomNo = getCellValue(cell11);
                // 所在库位
                Cell cell12 = row.getCell(12);
                String rackNo = getCellValue(cell12);
                // 批次号
                Cell cell13 = row.getCell(13);
                String materialBatchNo = getCellValue(cell13);

                // 实际单重
                Cell cell14 = row.getCell(14);
                String actualWeight = getCellValue(cell14);
                materialRequestDTO.setActualWeight(actualWeight);
                // 单价
                Cell cell15 = row.getCell(15);
                BigDecimal price=BigDecimal.ZERO;
                if(getCellValue(cell15)!=null){
                    price=new BigDecimal(getCellValue(cell15));
                }
                materialRequestDTO.setPrice(price);
                // 材料
                Cell cell17 = row.getCell(17);
                String material = getCellValue(cell17);
                materialRequestDTO.setMaterial(material);
                // 添加零件表
                materialService.save(materialRequestDTO);

                // 添加库房库存表
                EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO();
                entryOutStorageDTO.setMaterialBatchNo(materialBatchNo);
                entryOutStorageDTO.setRoomNo(roomNo);
                entryOutStorageDTO.setRackNo(rackNo);
                entryOutStorageDTO.setMaterialGraphNo(graphNo);
                entryOutStorageDTO.setQuantity(currentQuantity);
                byte operationType = CommonEnum.OperationType.ENTRY.code;
                byte storageType = CommonEnum.StorageType.MATERIAL.code;
                entryOutStorageDTO.setType(storageType);
                entryOutStorageDTO.setOperationType(operationType);
                stockService.addStock(entryOutStorageDTO);

                // 添加到零件价格表
                PriceMaterial priceMaterial=new PriceMaterial(){{
                    setMaterialClassifyName(classifyName);
                    setGraphNo(graphNo);
                    setName(name);
                    setModel(model);
                    setSpecifications(spec);
                    setMaterial(material);
                    setActualWeight(actualWeight);
                    // 毛坯价
                    Cell cell18 = row.getCell(18);
                    String  blankCost= getCellValue(cell18);
//                    setBlankCost(blankCost);
                    // 机加
                    Cell cell19 = row.getCell(19);
                    String  processCost= getCellValue(cell19);
//                    setProcessCost(processCost);
                }};
                priceMaterialService.saveInfo(priceMaterial);
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
