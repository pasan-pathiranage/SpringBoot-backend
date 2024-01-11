package com.sltc.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltc.database.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //Custom quaries
    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);
}
