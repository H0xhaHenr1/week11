package com.lhind.internship.jpaintro.service;

import com.lhind.internship.jpaintro.model.entity.UserDetails;
import com.lhind.internship.jpaintro.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails saveUserDetails(UserDetails userDetails){
        return userDetailsRepository.save(userDetails);
    }

    public Optional<UserDetails> getById(Long Id){
        return  userDetailsRepository.findById(Id);
    }

    public List<UserDetails> getAllFlights(){
        return userDetailsRepository.findAll();
    }

    public void deleteById(Long Id){
        userDetailsRepository.deleteById(Id);
    }

}
