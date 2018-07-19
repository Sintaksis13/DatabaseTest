package spring.db.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.db.test.entity.TestEntity;
import spring.db.test.context.TestRepository;

@Controller
@RequestMapping(value = "/hello")
public class TestController {
    private TestRepository testRepository;

    @Autowired
    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
/*
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllEntitiesAsJson(int id) {
        TestEntity entity = testRepository.findById(id).get();

        return entity.getSurname();
    }*/

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody TestEntity getEntityByIdAsXml(int id) {
        return testRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewEntity(String name, String surname) {
        TestEntity entity = new TestEntity(name, surname);
        testRepository.save(entity);
    }
}
