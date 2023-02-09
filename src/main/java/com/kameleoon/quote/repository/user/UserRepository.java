package com.kameleoon.quote.repository.user;

import com.kameleoon.quote.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmailIgnoreCase(String email);

    User save(User user);
}
