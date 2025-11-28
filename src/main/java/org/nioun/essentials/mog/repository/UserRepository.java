package org.nioun.essentials.mog.repository;

import org.nioun.essentials.mog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

User findByEmail(String email);
User findByFirstName(String name);

}
