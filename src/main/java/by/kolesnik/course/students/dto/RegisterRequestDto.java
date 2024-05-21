package by.kolesnik.course.students.dto;

import by.kolesnik.course.students.Role;
import lombok.Data;

@Data
public class RegisterRequestDto {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
