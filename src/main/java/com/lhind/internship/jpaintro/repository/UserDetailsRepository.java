package com.lhind.internship.jpaintro.repository;

import com.lhind.internship.jpaintro.model.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
