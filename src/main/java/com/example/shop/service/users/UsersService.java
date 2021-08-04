package com.example.shop.service.users;

import com.example.shop.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersService {
    void save(Users users);

    Optional<Users> findBySurnameAndPhone(String surname, String phoneNumber);
}
