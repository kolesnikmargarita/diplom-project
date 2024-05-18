package by.kolesnik.course.students.service;

import by.kolesnik.course.students.entity.User;
import by.kolesnik.course.students.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(String email, String password) {

        final User user = new User();
        user.setEmail(email);
        final String passwordHash = passwordEncoder.encode(password);
        user.setPassword(passwordHash);
        userRepository.save(user);
        return user;
    }
}
