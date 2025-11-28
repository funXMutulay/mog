package org.nioun.essentials.mog.repository;

import org.nioun.essentials.mog.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.util.List;


@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege , Long> {
 Privilege  findByName(String name);
}
