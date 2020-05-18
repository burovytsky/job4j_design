package ru.job4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte byteValue = 1;
        short shortValue = 2;
        int intValue = 3;
        long longValue = 4;
        double doubleValue = 5;
        float floatValue = 6;
        char charValue = 'c';
        boolean booleanValue = true;

        LOG.debug("byte : {}, short : {}, int : {}, long : {}, double : {}, float : {}, char : {}, boolean : {}",
                byteValue, shortValue, intValue, longValue, doubleValue, floatValue, charValue, booleanValue);

    }
}
