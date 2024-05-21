package by.kolesnik.course.students.mapper;

import by.kolesnik.course.students.dto.category.CategoryAddDto;
import by.kolesnik.course.students.dto.category.CategoryGetDto;
import by.kolesnik.course.students.dto.category.CategoryUpdateDto;
import by.kolesnik.course.students.dto.category.CategoryDto;
import by.kolesnik.course.students.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryUpdateDto dto) {

        Category category = new Category();

        category.setName(dto.getName());

        return category;
    }

    public Category toEntity(CategoryAddDto dto) {

        Category category = new Category();

        category.setName(dto.getName());

        return category;
    }

    public CategoryDto toDto(Category category) {

        CategoryDto dto = new CategoryDto();

        dto.setName(category.getName());

        return dto;
    }

    public CategoryGetDto toGetDto(Category category) {

        CategoryGetDto dto = new CategoryGetDto();

        dto.setId(category.getId());
        dto.setName(category.getName());

        return dto;
    }
}
