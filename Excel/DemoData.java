package com.hopes.learn2;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public class DemoData {
    @ExcelProperty(value = "卷内顺序号")
    private String index;

    @ExcelProperty(value = "档号")
    private String partNumber;

    @ExcelProperty(value = "题名")
    private String title;

    @ExcelProperty(value = "责任者")
    private String author;

    @ExcelProperty(value = "日期")
    private String date;

    @ExcelProperty(value = "页码范围")
    private String Page;
}
