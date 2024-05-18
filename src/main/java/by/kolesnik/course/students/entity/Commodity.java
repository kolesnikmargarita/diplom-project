package by.kolesnik.course.students.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity(name = "commodity")
@Table(name = "commodity")
@Data
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "article", unique = true)
    private Integer article;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "commodities")
    private Collection<User> users;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;
}
