package com.kameleoon.quote.service.user;

import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.repository.user.UserRepository;
import com.kameleoon.quote.to.user.UserTo;
import com.kameleoon.quote.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.kameleoon.quote.util.validation.ValidationUtil.checkNew;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;


    @Override
    public Optional<User> findByEmailIgnoreCase(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public User save(UserTo userTo) {
        log.info("register {}", userTo);
        checkNew(userTo);
        User newFromTo = UserUtil.createNewFromTo(userTo);
        return userRepository.save(UserUtil.prepareToSave(newFromTo));
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
