package com.deepsoft.haolifa.finance;

import com.deepsoft.haolifa.BaseTest;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.BizCostBudgetSubjects;
import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.domain.BizSubjectsExample;
import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CostServiceTest extends BaseTest {

    @Autowired
    private BizCostBudgetDeptMapper bizCostBudgetDeptMapper;

    @Autowired
    private BizCostBudgetSubjectsMapper bizCostBudgetSubjectsMapper;

    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private BizBillMapper bizBillMapper;

    @Autowired
    private BizOtherBillMapper bizOtherBillMapper;

    @Autowired
    private BizBankBillMapper bizBankBillMapper;

    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private BizSubjectsMapper subjectsMapper;

    @Autowired
    private BizSubjectsBalanceMapper subjectsBalanceMapper;

    @Test
    public void t1() {

        String a  = "24,0000301,0.012;\n" +
            "24,0000302,0.012;\n" +
            "24,0000303,0.002;\n" +
            "24,0000304,1.842;\n" +
            "24,0000305,0.012;\n" +
            "24,0000306,0.012;\n" +
            "24,0000401,0.000;\n" +
            "24,0000402,0.345;\n" +
            "24,0000403,0.092;\n" +
            "24,0000404,0.058;\n" +
            "24,0000405,0.345;\n" +
            "24,0000406,0.046;\n" +
            "24,0000407,0.002;\n" +
            "24,0000408,0.138;\n" +
            "24,0000409,0.230;\n" +
            "24,0000410,0.115;\n" +
            "24,0000801,0.023;\n" +
            "24,0000802,0.012;\n" +
            "24,0000803,6.608;\n" +
            "24,0000805,0.691;\n" +
            "24,0000806,0.012;\n" +
            "24,0001203,0.000;\n" +
            "24,0001204,0.345;\n" +
            "24,0001207,0.000;\n" +
            "24,0001208,0.115;\n" +
            "24,0001401,61.416;\n" +
            "24,0001402,10.361;\n" +
            "24,0001403,1.382;\n" +
            "24,0001502,1.335;\n" +
            "24,0001506,2.694;\n" +
            "24,0001507,1.266;\n" +
            "24,0001508,1.382;\n" +
            "24,0001509,3.224;\n" +
            "24,0001510,2.763;\n" +
            "24,0001511,3.108;\n" +
            "32,0000501,1.005;\n" +
            "32,0000502,5.529;\n" +
            "32,0000503,1.508;\n" +
            "32,0000504,2.011;\n" +
            "32,0000505,1.508;\n" +
            "32,0000506,1.005;\n" +
            "32,0000507,0.503;\n" +
            "32,0000114,2.011;\n" +
            "32,0000115,1.508;\n" +
            "32,0001503,83.442;\n" +
            "34,0000101,2.519;\n" +
            "34,0000102,0.969;\n" +
            "34,0000103,0.484;\n" +
            "34,0000104,0.039;\n" +
            "34,0000106,0.058;\n" +
            "34,0000107,9.687;\n" +
            "34,0000108,0.194;\n" +
            "34,0000109,0.581;\n" +
            "34,0000110,0.000;\n" +
            "34,0000111,0.581;\n" +
            "34,0000112,0.000;\n" +
            "34,0000113,0.155;\n" +
            "34,0000114,0.097;\n" +
            "34,0000116,0.194;\n" +
            "34,0000117,0.000;\n" +
            "34,0000118,0.872;\n" +
            "34,0000119,1.744;\n" +
            "34,0000120,2.712;\n" +
            "34,0000701,12.593;\n" +
            "34,0000702,0.252;\n" +
            "34,0000703,0.000;\n" +
            "34,0000704,0.000;\n" +
            "34,0000901,2.712;\n" +
            "34,0000902,0.097;\n" +
            "34,0000903,0.736;\n" +
            "34,0000904,0.872;\n" +
            "34,0000905,0.058;\n" +
            "34,0000906,0.000;\n" +
            "34,,6.393;\n" +
            "34,0001101,22.279;\n" +
            "34,0001102,1.550;\n" +
            "34,0001103,8.718;\n" +
            "34,0001104,0.000;\n" +
            "34,0001202,0.000;\n" +
            "34,0001206,0.000;\n" +
            "34,0001209,0.000;\n" +
            "34,0001210,14.530;\n" +
            "34,0001501,8.330;\n" +
            "38,0000105,1.994;\n" +
            "38,0000601,1.595;\n" +
            "38,0000602,0.854;\n" +
            "38,0000603,1.424;\n" +
            "38,0000604,3.418;\n" +
            "38,0000605,0.285;\n" +
            "38,0000606,0.854;\n" +
            "38,0000607,0.854;\n" +
            "38,0000608,0.285;\n" +
            "38,0000609,28.480;\n" +
            "38,0000610,1.424;\n" +
            "38,0000611,0.142;\n" +
            "38,0001205,0.000;\n" +
            "38,0001505,58.385;\n" +
            "35,0000115,0.177;\n" +
            "35,0000201,0.059;\n" +
            "35,0000202,0.030;\n" +
            "35,0000203,0.030;\n" +
            "35,0000204,0.006;\n" +
            "35,0000205,65.790;\n" +
            "35,0000206,0.177;\n" +
            "35,0000207,5.029;\n" +
            "35,0000208,0.059;\n" +
            "35,0001301,17.749;\n" +
            "35,0001302,1.242;\n" +
            "35,0001303,0.532;\n" +
            "35,0001304,0.355;\n" +
            "35,0001305,0.177;\n" +
            "35,0001306,0.473;\n" +
            "35,0001307,0.769;\n" +
            "35,0001308,0.769;\n" +
            "35,0001309,2.367;\n" +
            "35,0001310,0.538;\n" +
            "35,0001504,3.668;";


        BizSubjectsExample bizSubjectsExample = new BizSubjectsExample();
        bizSubjectsExample.createCriteria();
        List<BizSubjects> bizSubjectsList = subjectsMapper.selectByExample(bizSubjectsExample);
        Map<String, BizSubjects> collect1 = bizSubjectsList.stream()
            .collect(Collectors.toMap(BizSubjects::getCode, Function.identity(), (c, b) -> c));

        String[] split = a.split(";");
        for (int i = 0; i < split.length; i++) {
           String s =  split[i];
            String[] split1 = s.split(",");
           String s1 =  split1[0].trim();
           String s2 =  split1[1].trim();
           String s3 =  split1[2].trim();

            BizSubjects bizSubjects = collect1.get(s2);

            if (bizSubjects == null){
                continue;
            }
            BizCostBudgetSubjects costBudget = new BizCostBudgetSubjects();
            costBudget.setCostRatio(Double.parseDouble(s3));
            costBudget.setSubjectsId(bizSubjects.getId());


            costBudget.setName(bizSubjects.getName());
            costBudget.setDeptId(Integer.parseInt(s1));
            costBudget.setSubjectsType(bizSubjects.getType());

            int insertId = bizCostBudgetSubjectsMapper.insertSelective(costBudget);
        }

    }


}
