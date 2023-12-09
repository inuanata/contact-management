package contactmanagementrestfull.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import contactmanagementrestfull.entity.User;
import contactmanagementrestfull.model.RegisterUserRequest;
import contactmanagementrestfull.repository.UserRepository;
import contactmanagementrestfull.security.BCrypt;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ValidationService validationService;

  @Transactional
  public void register(RegisterUserRequest request) {
    validationService.validate(request);

    if(userRepository.existsById(request.getUsername())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
    }

    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt())); 
    user.setName(request.getName());

    userRepository.save(user);
  }
}
