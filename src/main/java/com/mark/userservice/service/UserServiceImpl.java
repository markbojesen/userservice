package com.mark.userservice.service;

import com.mark.userservice.domain.Role;
import com.mark.userservice.domain.User;
import com.mark.userservice.repository.RoleRepository;
import com.mark.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(final User user) {
        log.info("Saved user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(final Role role) {
        log.info("Saved role: {}", role);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(final String username, final String roleName) {
        log.info("Added role: {} to username: {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(final String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
