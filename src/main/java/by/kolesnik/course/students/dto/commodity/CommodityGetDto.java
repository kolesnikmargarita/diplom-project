package by.kolesnik.course.students.dto.commodity;

import by.kolesnik.course.students.entity.Category;
import by.kolesnik.course.students.entity.User;
import lombok.Data;

import java.util.Collection;

@Data
public class CommodityGetDto {

    private Long id;
    private Integer article;
    private String name;
    private Float price;
    private String description;
    private String categoryName;
}
