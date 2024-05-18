package by.kolesnik.course.students.service;

import by.kolesnik.course.students.entity.User;
import by.kolesnik.course.students.model.ExtendedUserDetails;
import by.kolesnik.course.students.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public ExtendedUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь не найден: %s".formatted(username));
        }

        return ExtendedUserDetails.create(
                optionalUser.get()
        );
    }
}
