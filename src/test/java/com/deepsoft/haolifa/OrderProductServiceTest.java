package com.deepsoft.haolifa;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.dto.OrderProductDTO;
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
        String fileBase64Str = Base64Utils.encryptToBase64("d:\\123.xls");
        System.out.println(fileBase64Str);
        ResultBean resultBean = orderService.uploadOrderProductExcel(fileBase64Str);
        OrderProductDTO order = JSONObject.parseObject(JSONObject.toJSONString(resultBean.getResult()), OrderProductDTO.class);
        orderService.saveOrderProductInfo(order);
    }
}
