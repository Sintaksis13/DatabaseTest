package spring.db.test;

import spring.db.test.context.TestContext;
import spring.db.test.controller.TestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Start {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestContext.class);

        TestController testController = context.getBean(TestController.class);
        testController.addNewEntity("hello", "world");

        System.out.println(testController.getAllEntitiesAsJson());
    }
}
