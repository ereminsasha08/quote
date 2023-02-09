package com.kameleoon.quote.repository.user;

import com.kameleoon.quote.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataJpaRepository extends UserRepository, JpaRepository<User, Integer> {
}
