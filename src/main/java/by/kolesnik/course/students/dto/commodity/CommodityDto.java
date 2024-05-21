package by.kolesnik.course.students.dto.commodity;

import by.kolesnik.course.students.entity.Category;
import by.kolesnik.course.students.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Collection;

@Data
public class CommodityDto {

    private Long id;
    private Integer article;
    private String name;
    private Float price;
    private String description;
    private Collection<User> users;
    private Category category;
}
