package com.deepsoft.haolifa;

import com.deepsoft.haolifa.service.DemoService;
import org.junit.Test;

import javax.annotation.Resource;
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

}
