package com.deepsoft.haolifa;

import com.deepsoft.haolifa.service.OrderService;
import com.deepsoft.haolifa.util.Base64Utils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class OrderServiceTest extends BaseApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void uploadOrderExcelTest() {
        String fileBase64Str = Base64Utils.encryptToBase64("d:\\123.xls");
        System.out.println(fileBase64Str);
        orderService.uploadOrderExcel(fileBase64Str);

    }
}
