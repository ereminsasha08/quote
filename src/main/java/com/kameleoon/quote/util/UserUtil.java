package com.kameleoon.quote.util;

import com.kameleoon.quote.domain.user.Role;
import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.to.UserTo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserUtil {

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.USER);
    }

    public static User prepareToSave(User user) {
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}