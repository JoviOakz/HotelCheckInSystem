package com.jovioakz;

public class Par {
    public String ParImparValidate(int num) {
        if (num == 0) {
            return "Par";
        }

        if (num % 2 == 0) {
            return "Par";
        } else {
            return "Impar";
        }
    }
}