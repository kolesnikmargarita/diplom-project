package by.kolesnik.course.students.repository;

import by.kolesnik.course.students.entity.Category;
import by.kolesnik.course.students.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {

    List<Commodity> findAllByCategory(Category category);

    Optional<Commodity> findByArticle(Integer article);
}
