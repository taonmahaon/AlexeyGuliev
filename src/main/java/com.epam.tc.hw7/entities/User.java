package com.epam.tc.hw7.entities;

import com.epam.jdi.tools.DataClass;
import com.epam.tc.hw7.utils.GetPropertyFile;

public class User extends DataClass<User> {
    public String name;
    public String password;
    public String fullName;

    public static User USER_ROMAN = new User().set(
        user -> {
            user.name = GetPropertyFile.getProperty().getProperty("name");
            user.password = GetPropertyFile.getProperty().getProperty("password");
            user.fullName = GetPropertyFile.getProperty().getProperty("fullName");
        }
    );
}
