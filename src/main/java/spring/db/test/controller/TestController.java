package spring.db.test.controller;

import spring.db.test.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.db.test.repository.TestRepository;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class TestController {
    @Autowired
    private TestRepository testRepository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllEntitiesAsJson() {
        List<TestEntity> all = testRepository.findAll();
        return all.get(0).getName();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public String getEntityByIdAsXml(int id) {
        TestEntity entity = testRepository.findById(id).get();
        return entity.getName();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewEntity(String name, String surname) {
        TestEntity entity = new TestEntity(name, surname);
        testRepository.save(entity);
    }
}
