package by.kolesnik.course.students.mapper;

import by.kolesnik.course.students.dto.RegisterRequestDto;
import by.kolesnik.course.students.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(RegisterRequestDto dto) {

        final User user = new User();

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setRole(dto.getRole());

        return user;
    }
}
