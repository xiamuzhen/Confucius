package com.hopes.template;

public class ReferenceCodeSplit {
    public static final String DELIMITER = "-";

    public String splitFileNumber(String referenceCode) {
        String[] temp = referenceCode.split(DELIMITER);
        return temp[temp.length - 2];
    }

    public String splitItemNumber(String referenceCode) {
        String[] temp = referenceCode.split(DELIMITER);
        return temp[temp.length - 1];
    }
}
