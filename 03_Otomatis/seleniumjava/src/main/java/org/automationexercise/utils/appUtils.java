package org.automationexercise.utils;

import java.time.Instant;

// TODO Utilization method for generating data test
public class appUtils {

    // Method to get current timestamp in epoch milliseconds
    public long getCurrentTimestampMillis() {
        return Instant.now().toEpochMilli();
    }
}
