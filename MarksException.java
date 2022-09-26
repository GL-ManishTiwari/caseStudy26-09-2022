package com.casestudies;

public class MarksException extends RuntimeException {
    // raise ecception for -ve or above 100 marks
    public MarksException(String str) {
        super(str);
    }
}
