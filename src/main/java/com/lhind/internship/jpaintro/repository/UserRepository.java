package com.lhind.internship.jpaintro.repository;

import com.lhind.internship.jpaintro.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
