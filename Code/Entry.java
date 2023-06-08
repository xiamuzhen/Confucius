package com.hopes.template;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

@Data
public class Entry {
    @ExcelProperty(value = "档号")
    private String referenceCode;

//    private String fondsNumber;
//
//    private String seriesNumber;
//
//    private String fileNumber;
//
//    private String itemNumber;
//
//    private String pageNumber;

    @ExcelProperty(value = "起页号")
    private String startPageNumber;

    @ExcelProperty(value = "止页号")
    private String endPageNumber;

    @ExcelProperty(value = "页数")
    private String pagesNumber;


}
