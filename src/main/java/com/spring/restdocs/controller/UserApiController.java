package com.spring.restdocs.controller;

import com.spring.restdocs.model.Header;
import com.spring.restdocs.model.User;
import com.spring.restdocs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

  private final UserService userService;

  public UserApiController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("")
  public Header<User> create(@RequestBody User requestUser) {
    User user = userService.create(requestUser);
    if (user != null) {
      return Header.OK(user);
    }
    return Header.ERROR();
  }

  @GetMapping("{id}")
  public Header<User> read(@PathVariable(name = "id") Long id) {
    User user = userService.read(id);
    if (user != null) {
      return Header.OK(user);
    }
    return Header.ERROR();
  }

  @PutMapping("")
  public Header<User> update(@RequestBody User requestUser) {
    User user = userService.update(requestUser);
    if (user != null) {
      return Header.OK(user);
    }
    return Header.ERROR();
  }

  @DeleteMapping("{id}")
  public Header<User> delete(@PathVariable(name = "id") Long id) {
    boolean isDelete = userService.delete(id);
    if (isDelete) {
      return Header.OK();
    }
    return Header.ERROR();

  }

}
