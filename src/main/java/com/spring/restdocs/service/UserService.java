package com.spring.restdocs.service;

import com.spring.restdocs.model.User;
import com.spring.restdocs.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public User create(User user) {
    user.setCreatedAt(LocalDateTime.now());
    return userRepository.save(user);
  }

  public User read(Long id) {
    return userRepository.findById(id)
        .orElse(null);
  }

  public User update(User requestUser) {
    Optional<User> optionalUser = userRepository.findById(requestUser.getId());

    return optionalUser.map(dbUser -> {
      dbUser.setAccount(requestUser.getAccount());
      dbUser.setEmail(requestUser.getEmail());
      dbUser.setPhoneNumber(requestUser.getPhoneNumber());
      dbUser.setUpdatedAt(LocalDateTime.now());
      return dbUser;
    })
        .map(userRepository::save)
        .orElse(null);
  }

  public boolean delete(Long id) {
    return userRepository.findById(id)
        .map(user -> {
          userRepository.deleteById(id);
          return true;
        }).orElse(false);
  }


  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}
