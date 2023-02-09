package com.kameleoon.quote.service.user;

import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.repository.user.UserRepository;
import com.kameleoon.quote.to.UserTo;
import com.kameleoon.quote.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.kameleoon.quote.util.validation.ValidationUtil.checkNew;

@Service
@RequiredArgsConstructor

public class UserServiceImp implements UserService{

    private final UserRepository userRepository;


    @Override
    public Optional<User> findByEmailIgnoreCase(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public User save(UserTo userTo) {
        checkNew(userTo);
        User newFromTo = UserUtil.createNewFromTo(userTo);
        return userRepository.save(UserUtil.prepareToSave(newFromTo));
    }
}
