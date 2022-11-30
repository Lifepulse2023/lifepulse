package com.lifepulse.api.repository;

import com.lifepulse.api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRegistrationRepository extends CrudRepository<User, Integer> {
}
