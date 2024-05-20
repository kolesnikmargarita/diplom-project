package by.kolesnik.course.students.service;

import by.kolesnik.course.students.entity.User;
import by.kolesnik.course.students.exception.EntityNotFoundException;
import by.kolesnik.course.students.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(User user) {

        final String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
        return user;
    }

    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        return user.get();
    }
}
