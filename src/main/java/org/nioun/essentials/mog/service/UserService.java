package org.nioun.essentials.mog.service;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.nioun.essentials.mog.model.User;

@Component
public interface UserService {

	User saveUser(User user);

	User updateUser(User user);

	void deleteUser(User user);

	User getUserById(Long id);

	List<User> getAllUsers();
}
