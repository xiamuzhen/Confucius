package com.hopes.template;

public class Test {

    public static void main(String[] args) {

        ExcelRead excelRead = new ExcelRead();

        ReferenceCodeAnalysis referenceCodeAnalysis = new ReferenceCodeAnalysis();
        referenceCodeAnalysis.check(excelRead.readLines("C:\\Users\\Hopes\\Desktop\\EntryData.xlsx"));
    }
}
