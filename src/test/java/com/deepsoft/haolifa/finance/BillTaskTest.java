package com.deepsoft.haolifa.finance;

import com.deepsoft.haolifa.BaseTest;
import com.deepsoft.haolifa.dao.repository.BizCostBudgetDeptMapper;
import com.deepsoft.haolifa.model.domain.BizCostBudgetSubjects;
import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.domain.BizSubjectsExample;
import com.deepsoft.haolifa.task.BillTask;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BillTaskTest extends BaseTest {

    @Autowired
    private BillTask billTask;



    @Test
    public void t1() {

        billTask.scheduleBill();

    }


}
