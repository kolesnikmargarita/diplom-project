package by.kolesnik.course.students.dto;

import by.kolesnik.course.students.Role;
import lombok.Data;

@Data
public class UserDto{
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
