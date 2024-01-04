package com.example.demo5;

import java.time.Instant;

public class uniqueCode {

    public static long Unique() {
        long timestamp = Instant.now().toEpochMilli();
        return timestamp;
    }
}
