package by.kolesnik.course.students.dto.category;

import by.kolesnik.course.students.entity.Commodity;
import lombok.Data;

import java.util.Collection;

@Data
public class CategoryDto {

    private Long id;
    private String name;
    private Collection<Commodity> commodities;
}
