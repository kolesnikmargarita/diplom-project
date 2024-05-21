package by.kolesnik.course.students.dto.commodity;

import by.kolesnik.course.students.entity.Commodity;
import lombok.Data;

@Data
public class CommodityUpdateDto {

    private String name;
    private Float price;
    private String description;
    private String categoryName;
}
