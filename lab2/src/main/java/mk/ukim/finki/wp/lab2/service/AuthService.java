package mk.ukim.finki.wp.lab2.service;


import mk.ukim.finki.wp.lab2.model.User;

public interface AuthService {
    User login(String username, String password);
}
