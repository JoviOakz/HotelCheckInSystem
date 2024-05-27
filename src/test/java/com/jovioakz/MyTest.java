package com.jovioakz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// A classe deve terminar com 'Test' no nome.
class MyTest {
    private final DateValidator validator = new DateValidator();
    private final Par Pvalidator = new Par();
    private final CousinValidator Cvalidator = new CousinValidator();
    private final CollatzValidator Colvalidator = new CollatzValidator();

    @Test
    void validate() {
        // Data
        assertEquals(validator.validate(29, 2, 2024), true);

        assertEquals(validator.validate(29, 2, 2025), false);

        assertEquals(validator.validate(30, 2, 2024), false);

        assertEquals(validator.validate(30, 12, 1800), true);

        assertEquals(validator.validate(29, 2, 1800), false);

        assertEquals(validator.validate(29, 2, 1600), true);

        assertEquals(validator.validate(4, 1, 2023), true);

        assertEquals(validator.validate(31, 4, 2000), false);

        assertEquals(validator.validate(29, 4, 2001), true);

        // Par ou impar
        assertEquals(Pvalidator.ParImparValidate(2), "Par");
        
        assertEquals(Pvalidator.ParImparValidate(0), "Par");

        assertEquals(Pvalidator.ParImparValidate(90), "Par");

        assertEquals(Pvalidator.ParImparValidate(7), "Impar");

        assertEquals(Pvalidator.ParImparValidate(73), "Impar");

        assertEquals(Pvalidator.ParImparValidate(-1), "Impar");

        assertEquals(Pvalidator.ParImparValidate(-98), "Par");

        // Primos
        assertEquals(Cvalidator.CousinValidate(1), false);

        assertEquals(Cvalidator.CousinValidate(20), false);

        assertEquals(Cvalidator.CousinValidate(2), true);

        assertEquals(Cvalidator.CousinValidate(11), true);

        assertEquals(Cvalidator.CousinValidate(13), true);

        assertEquals(Cvalidator.CousinValidate(0), false);

        assertEquals(Cvalidator.CousinValidate(-8), false);

        assertEquals(Cvalidator.CousinValidate(-23), false);

        // Collatz
        assertEquals(Colvalidator.CollatzValidate(6), true);

        assertEquals(Colvalidator.CollatzValidate(0), false);

        assertEquals(Colvalidator.CollatzValidate(-23), false);

        assertEquals(Colvalidator.CollatzValidate(45), true);
    }
}