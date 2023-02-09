package com.kameleoon.quote.repository.user;

import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.repository.BaseRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByEmailIgnoreCase(String email);

    User save(User user);

    User findByName(String name);
}
