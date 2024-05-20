package by.kolesnik.course.students.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity(name = "categories")
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Collection<Commodity> commodities;
}
