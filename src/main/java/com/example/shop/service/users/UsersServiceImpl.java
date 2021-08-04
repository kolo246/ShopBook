package com.example.shop.service.users;

import com.example.shop.entity.Users;
import com.example.shop.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersRepo usersRepo;

    public UsersServiceImpl(){}

    @Override
    public void save(Users users) {
        usersRepo.save(users);
    }

    @Override
    public Optional<Users> findBySurnameAndPhone(String surname, String phoneNumber) {
        return usersRepo.findBySurnameAndPhone(surname, phoneNumber);
    }
}
