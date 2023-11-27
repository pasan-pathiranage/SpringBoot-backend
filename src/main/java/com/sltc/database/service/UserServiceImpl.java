package com.sltc.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sltc.database.dto.UserPwdDto;
import com.sltc.database.entity.User;
import com.sltc.database.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User creatUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User changeUserPassword(Long id, UserPwdDto userPwdDto) {

        User user = userRepository.findById(id).orElse(null);

        System.out.println(userPwdDto.getPassword()); // debuging

        if (user != null) {
            user.setPassword(userPwdDto.getPassword());
            return userRepository.save(user);

        } else {
            return null;
        }

    }
}
