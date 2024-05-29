package com.jovioakz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// A classe deve terminar com 'Test' no nome.
class MyTest {

    @Test
    void validate() {
        // Data
        assertEquals(true, TimeValidator.validateTime("23:00"));
        assertEquals(false, TimeValidator.validateTime("26:00"));
        assertEquals(true, TimeValidator.validateTime("21:00"));
        assertEquals(false, TimeValidator.validateTime("-10:00"));
        assertEquals(false, TimeValidator.validateTime("24:00"));
        assertEquals(true, TimeValidator.validateTime("22:11"));
        assertEquals(true, TimeValidator.validateTime("2:59"));
        assertEquals(false, TimeValidator.validateTime("23:60"));
        assertEquals(false, TimeValidator.validateTime("23:100"));
    }
}