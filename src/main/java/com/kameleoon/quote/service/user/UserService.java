package com.kameleoon.quote.service.user;

import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.to.user.UserTo;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmailIgnoreCase(String email);


    User save(UserTo userTo);

    User findByName(String name);
}
