package by.kolesnik.course.students.dto.commodity;

import lombok.Data;

@Data
public class CommodityAddDto {

    private Integer article;
    private String name;
    private Float price;
    private String description;
}
