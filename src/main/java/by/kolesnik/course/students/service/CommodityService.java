package by.kolesnik.course.students.service;

import by.kolesnik.course.students.entity.Category;
import by.kolesnik.course.students.entity.Commodity;
import by.kolesnik.course.students.exception.EntityNotFoundException;
import by.kolesnik.course.students.repository.CommodityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommodityService {

    private final CommodityRepository repository;

    public List<Commodity> findAll() {
        return repository.findAll();
    }

    public List<Commodity> findByCategory(Category category) {
        return repository.findAllByCategory(category);
    }

    public Commodity save(Commodity commodity) {
        return repository.save(commodity);
    }

    public Commodity findByArticle(Integer article) {
        Optional<Commodity> commodity = repository.findByArticle(article);
        if(commodity.isEmpty()) {
            throw new EntityNotFoundException("Товар с артикулом " + article + " не найден");
        }
        return commodity.get();
    }

    public void delete(Commodity commodity) {
        repository.delete(commodity);
    }
}
