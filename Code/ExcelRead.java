package com.hopes.template;

import com.alibaba.excel.EasyExcel;

import java.util.List;

public class ExcelRead {

    public List<Entry> readLines(String fileName) {
        List<Entry> linesList = EasyExcel
                .read(fileName, Entry.class, new DemoDataListener())
                .sheet()
                .headRowNumber(1)
                .doReadSync();
        return linesList;
    }
}
