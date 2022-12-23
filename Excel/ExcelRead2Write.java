package com.hopes.learn2;

import com.alibaba.excel.EasyExcel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 张淑波
 * @Date 2022-12-22
 * @Describe Contents Automation
 * @Since 1.0
 */
public class ExcelRead2Write {

    public static void main(String[] args) throws FileNotFoundException {
        // 源目录数据文件
        String sourceFileName = "C:\\Users\\Hopes\\Desktop\\目录.xlsx";
        // 模板数据文件
        String templateFileName = "C:\\Users\\Hopes\\Desktop\\目录模板.xlsx";
        // 逐行读取源目录数据文件
        List<DemoData> tempList = EasyExcel
                .read(sourceFileName, DemoData.class, new DemoDataListener())
                .sheet(0)
                .headRowNumber(1)
                .doReadSync();

        // 写入数据临时存放
        List<DemoData> fileList = new ArrayList<>();
        // 当前行数据
        String current = null;
        // 当前案卷号
        String index = null;

        // 根据获取的源目录数据生成案卷模板
        for (int i = 1; i < tempList.size(); i++) {
            // 当前档号
            current = tempList.get(i).getPartNumber().substring(0, 23);
            // 上一卷档号
            String previous = tempList.get(i - 1).getPartNumber().substring(0, 23);
            // 下一卷档号
            String next = tempList.get(i + 1).getPartNumber().substring(0, 23);
            // 当前案卷号
            index = current.substring(19, 23);
            // 写入索引
            String destinationFileName = "C:\\Users\\Hopes\\Desktop\\Contents\\" + index + ".xlsx";

            if (current.equals(next) // 如果当前档号等于下一卷档号
                    // 如果当前档号不等于上一卷档号且等于下一卷档号
                    || (!current.equals(previous) && current.equals(next))
                    // 如果当前档号等于上一卷档号且不等于下一卷档号
                    || (current.equals(previous) && !current.equals(next))) {
                fileList.add(tempList.get(i));
                EasyExcel.write(destinationFileName).withTemplate(templateFileName).sheet().doFill(fileList);

                if (!current.equals(next)) {
                    fileList.clear(); // 如果当前档号不等于下一卷档号，则写入数据临时存放为空
                }
            } else if (!current.equals(previous) && !current.equals(next)) { // 如果当前档号不等于上一卷档号也不等于下一卷档号
                fileList.add(tempList.get(i));
                EasyExcel.write(destinationFileName).withTemplate(templateFileName).sheet().doFill(fileList);
                fileList.clear();
            } else {
                // 如果一卷目录数据写入完成，则当前行数据档号为空
                current = null;
                // 如果一卷目录数据写入完成，则当前案卷号为空
                index = null;
            }
            System.out.println(tempList.get(i).getPartNumber().substring(0, 27) + " Parsing completed.");
        }

    }
}
