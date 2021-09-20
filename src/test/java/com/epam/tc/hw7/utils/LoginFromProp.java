package com.epam.tc.hw7.utils;

import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.UIFactory.$;

import com.epam.tc.hw4.utils.GetPropertyFile;

public class LoginFromProp {
    public static void login() {
        openUrl("https://jdi-testing.github.io/jdi-light/");
        $("img#user-icon").click();
        $("#name").sendKeys(GetPropertyFile.getProperty().getProperty("name"));
        $("#password").sendKeys(GetPropertyFile.getProperty().getProperty("password"));
        $("#login-button").click();
        $("#user-name").is().text(GetPropertyFile.getProperty().getProperty("fullName"));
    }
}
