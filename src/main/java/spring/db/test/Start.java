package spring.db.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.db.test.context.TestContext;
import spring.db.test.controller.TestController;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestContext.class);

        TestController testController = context.getBean(TestController.class);
        testController.addNewEntity("hello", "world");
        testController.addNewEntity("yes", "close");

        System.out.println(testController.getEntityByIdAsXml(1));

        /*System.out.println(testController.getAllEntitiesAsJson(2));*/
    }
}
