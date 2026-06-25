package com.budgetflow.demo.repository;

import com.budgetflow.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByNameAndEmail(String name, String email);

}
