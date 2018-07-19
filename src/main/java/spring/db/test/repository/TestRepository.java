package spring.db.test.repository;

import org.springframework.stereotype.Repository;
import spring.db.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}
