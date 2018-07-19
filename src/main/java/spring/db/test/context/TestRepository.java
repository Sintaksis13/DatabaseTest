package spring.db.test.context;

import org.springframework.data.repository.CrudRepository;
import spring.db.test.entity.TestEntity;

public interface TestRepository extends CrudRepository<TestEntity, Integer> {

}
