package com.epam.tc.hw3;

import java.util.List;

public class Constants {
    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final List<String> HEADER_EXPECTED_TEXT = List.of(
        "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    protected static final List<String> LOG_EXPECTED_TEXT = List.of(
        "Yellow", "Selen", "Wind", "Water");

    protected static final List<String> BENEFIT_EXPECTED_TEXT = List.of(
        "To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
    );

    protected static final List<String> SIDEBAR_EXPECTED_TEXTS = List.of(
        "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
}
