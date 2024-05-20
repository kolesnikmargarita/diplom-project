package by.kolesnik.course.students.mapper;

import by.kolesnik.course.students.dto.CategoryDto;
import by.kolesnik.course.students.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryDto dto) {

        Category category = new Category();

        category.setName(dto.getName());

        return category;
    }

    public CategoryDto toDto(Category category) {

        CategoryDto dto = new CategoryDto();

        dto.setName(category.getName());

        return dto;
    }
}
