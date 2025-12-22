package mk.ukim.finki.wp.lab2.service;

import mk.ukim.finki.wp.lab2.model.User;
import mk.ukim.finki.wp.lab2.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
        }
        return this.userRepository.findByUsernameAndPassword(username, password).orElseThrow();
    }
}
