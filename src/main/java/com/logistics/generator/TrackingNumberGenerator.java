package com.logistics.generator;

import org.springframework.stereotype.Component;
import java.security.SecureRandom;
import java.util.stream.Collectors;

@Component
public class TrackingNumberGenerator {
    private static final String ALLOWED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 12;
    private final SecureRandom random = new SecureRandom();

    public String generate(String originCountry, String destinationCountry) {
        String prefix = originCountry + destinationCountry;
        String randomPart = random.ints(LENGTH - 4, 0, ALLOWED_CHARS.length())
                .mapToObj(i -> String.valueOf(ALLOWED_CHARS.charAt(i)))
                .collect(Collectors.joining());
        return prefix + randomPart;
    }
}