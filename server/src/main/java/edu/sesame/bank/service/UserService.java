package edu.sesame.bank.service;

import edu.sesame.bank.entity.User;
import edu.sesame.bank.repository.UserRepository;
import edu.sesame.bank.security.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User findCurrentUser() {
        String login = SecurityUtils.getCurrentUserName()
                .orElseThrow(() -> new IllegalStateException("Current user login not found"));
        return userRepository.findOneByLogin(login).get();
    }


}
