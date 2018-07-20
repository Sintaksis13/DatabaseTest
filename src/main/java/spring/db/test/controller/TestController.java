package spring.db.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.db.test.context.TestRepository;
import spring.db.test.entity.TestEntity;

@Controller
public class TestController {
    private TestRepository testRepository;

    @Autowired
    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @RequestMapping(value = "/getJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<TestEntity> getAllInJSON() {
        return testRepository.findAll();
    }

    @RequestMapping(value = "/getXml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public TestEntity getEntityByIdAsXml(int id) {
        return testRepository.findById(id).get();
    }

    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    @ResponseBody
    public String addNewEntity(String name, String surname) {
        TestEntity entity = new TestEntity(name, surname);
        testRepository.save(entity);
        return "<h1>Entity was added to database!</h1>" +
                "\n<p><a href=\"index.jsp\">Return</a></p>";
    }
}
