package com.jovioakz;

public class CousinValidator {
    public Boolean CousinValidate(int num) {
        if (num <= 1) {
            return false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0)
                    return false;
            }
        }

        return true;
    }
}