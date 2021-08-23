package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtil {

    @Attachment(type = "image/png", value = "{name}")
    public static byte[] makeScreenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
