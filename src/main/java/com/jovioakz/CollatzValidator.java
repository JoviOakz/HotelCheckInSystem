package com.jovioakz;

public class CollatzValidator {
    public Boolean CollatzValidate(int num) {
        if (num < 1) {
            return false;
        } else {
            while (num != 1) {
                if (num % 2 == 0) 
                    num /= 2;
                else 
                    num = (3 * num) + 1;
            }

            return true;
        }
    }
}