package com.example.dbunitest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
//@Transactional
class DbunitestApplicationTests {

    @Autowired
    HelloWorldService helloWorldService;

    @Autowired
    HelloWorldRepository helloWorldRepository;

    @Test
    @DatabaseSetup("/dbunit/sampleData.xml")
    public void testCase1() {
        helloWorldRepository.flush();
        String a = helloWorldService.getString();
        fail();
    }

}
