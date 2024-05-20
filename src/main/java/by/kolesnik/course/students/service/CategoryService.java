package by.kolesnik.course.students.service;

import by.kolesnik.course.students.entity.Category;
import by.kolesnik.course.students.exception.EntityNotFoundException;
import by.kolesnik.course.students.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public Category findByName(String categoryName) {
        Optional<Category> category = repository.findByName(categoryName);

        if(category.isEmpty()) {
            throw new EntityNotFoundException("Категория не найдена");
        }

        return category.get();
    }
}
