package contactmanagementrestfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contactmanagementrestfull.model.RegisterUserRequest;
import contactmanagementrestfull.model.WebResponse;
import contactmanagementrestfull.model.UserResponse;
import contactmanagementrestfull.model.UpdateUserRequest;
import contactmanagementrestfull.entity.User;
import contactmanagementrestfull.service.UserService;

@RestController
public class UserController {
  
  @Autowired
  private UserService userService;

  @PostMapping(
    path = "/api/register",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
    userService.register(request);
    return WebResponse.<String>builder().data("OK").build();
  }

  @GetMapping(
    path = "/api/users/current",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public WebResponse<UserResponse> get(User user) {
    UserResponse userResponse = userService.get(user);
    return WebResponse.<UserResponse>builder().data(userResponse).build();
  }

  @PatchMapping(
      path = "/api/users/current",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> update(User user, @RequestBody UpdateUserRequest request) {
      UserResponse userResponse = userService.update(user, request);
      return WebResponse.<UserResponse>builder().data(userResponse).build();
    }
}
