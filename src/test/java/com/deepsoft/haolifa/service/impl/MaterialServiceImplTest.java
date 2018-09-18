package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.BaseApplicationTests;
import com.deepsoft.haolifa.service.MaterialService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @className: MaterialServiceImplTest
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2018-09-10 15:55
 **/
public class MaterialServiceImplTest extends BaseApplicationTests {

    @Autowired
    private MaterialService materialService;

    @Test
    public void updateCurrentQuantity() {
        int i = materialService.updateCurrentQuantity("3001", 2);
    }
}
