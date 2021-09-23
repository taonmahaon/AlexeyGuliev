package com.epam.tc.hw7.sites;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.tc.hw7.sites.pages.HomePage;
import com.epam.tc.hw7.sites.pages.MetalColorPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestingSite {
    public static HomePage homePage;
    public static MetalColorPage metalColorPage;
}

