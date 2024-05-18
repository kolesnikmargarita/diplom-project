package by.kolesnik.course.students.service;

import by.kolesnik.students.entity.User;
import by.kolesnik.students.repository.UserRepository;
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
    public User createUser(String username, String password) {

        final User user = new User();
        user.setUsername(username);
        final String passwordHash = passwordEncoder.encode(password);
        user.setPassword(passwordHash);
        userRepository.save(user);
        return user;
    }
}
