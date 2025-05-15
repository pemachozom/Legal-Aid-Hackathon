package com.synchrotech.lac_datamanagement.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.synchrotech.lac_datamanagement.models.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    @Query("{'email':?0}")
    Optional<User> findByEmail(String email);
}
