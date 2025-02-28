package com.lhind.internship.jpaintro.repository;

import com.lhind.internship.jpaintro.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u from User u LEFT JOIN FETCH u.userDetails")
    List<User> findAllUsersWithDetails();

    @Query("SELECT u from User u LEFT JOIN FETCH u.userDetails WHERE u.id = :userId")
    Optional<User> findUserWithDetailsById(@Param("id") Long userId);
}
