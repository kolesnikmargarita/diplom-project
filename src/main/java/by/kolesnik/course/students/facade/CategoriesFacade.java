package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.CategoryDto;
import by.kolesnik.course.students.entity.Category;
import by.kolesnik.course.students.mapper.CategoryMapper;
import by.kolesnik.course.students.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesFacade {

    private final CategoryService categoryservice;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getAll() {
        return categoryservice.findAll().stream().map(categoryMapper::toDto).toList();
    }

    public CategoryDto add(CategoryDto dto) {
        final Category category = categoryMapper.toEntity(dto);
        return categoryMapper.toDto(categoryservice.save(category));
    }

    public CategoryDto update(String categoryName, CategoryDto dto) {
        final Category category = categoryservice.findByName(categoryName);
        category.setName(dto.getName());
        return categoryMapper.toDto(categoryservice.save(category));
    }
}
