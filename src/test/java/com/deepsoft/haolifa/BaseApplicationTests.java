package com.deepsoft.haolifa;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BaseApplicationTests {

    private Long startTimeMillis = 0l;

    @Before
    public void runBeforeAll() throws Exception {
        startTimeMillis = System.currentTimeMillis();
    }

    @After
    public void runAfterAll() throws Exception {
        System.out.println("total use timeMillis=>" + String.valueOf(System.currentTimeMillis() - startTimeMillis));
    }
}
