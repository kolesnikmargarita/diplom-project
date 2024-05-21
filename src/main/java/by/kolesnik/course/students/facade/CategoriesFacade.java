package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.category.CategoryAddDto;
import by.kolesnik.course.students.dto.category.CategoryGetDto;
import by.kolesnik.course.students.dto.category.CategoryUpdateDto;
import by.kolesnik.course.students.dto.category.CategoryDto;
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

    public List<CategoryGetDto> getAll() {
        return categoryservice.findAll().stream().map(categoryMapper::toGetDto).toList();
    }

    public CategoryGetDto add(CategoryAddDto dto) {
        final Category category = categoryMapper.toEntity(dto);
        return categoryMapper.toGetDto(categoryservice.save(category));
    }

    public CategoryGetDto update(String categoryName, CategoryUpdateDto dto) {
        final Category category = categoryservice.findByName(categoryName);
        category.setName(dto.getName());
        return categoryMapper.toGetDto(categoryservice.save(category));
    }
}
