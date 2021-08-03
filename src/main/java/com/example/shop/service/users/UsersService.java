package com.example.shop.service.users;

import com.example.shop.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersService {
    void save(Users users);
    List<Users> findAll();
    void remove(Users users);
    Optional<Users> findBySurnameAndPhone(String surname, String phoneNumber);
}
