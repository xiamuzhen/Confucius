package com.hopes.template;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class ReferenceCodeAnalysis {
    public void check(List<Entry> entriesList) {
        List<Entry> filesNumberList = new ArrayList<>();   // 案卷案件

        String referenceCode = null;            //当前档号
        String previousFileNumber = null;       //上一卷案卷号
        String nextFileNumber = null;           //下一卷案卷号
        String fileNumber = null;               //当前案卷号
        String startPageNumber = null;          //当前案卷起始页号
        String endPageNumber = null;            //当前案卷终止页号
        String pageNumber = null;               //当前页号

        for (int i = 0; i < entriesList.size(); i++) {
            // 当前档号
            referenceCode = entriesList.get(i).getReferenceCode();

            // 截取档号中案卷号
            fileNumber = new ReferenceCodeSplit().splitFileNumber(referenceCode);

            // 当解析案卷首行和末行数据时
            if (i == 0) {
                previousFileNumber = null;
                nextFileNumber = entriesList.get(i + 1).getReferenceCode();
                nextFileNumber = new ReferenceCodeSplit().splitFileNumber(nextFileNumber);
            } else if (i == entriesList.size() - 1) {
                previousFileNumber = entriesList.get(i - 1).getReferenceCode();
                previousFileNumber = new ReferenceCodeSplit().splitFileNumber(previousFileNumber);
                nextFileNumber = null;
            } else {
                previousFileNumber = entriesList.get(i - 1).getReferenceCode();
                previousFileNumber = new ReferenceCodeSplit().splitFileNumber(previousFileNumber);
                nextFileNumber = entriesList.get(i + 1).getReferenceCode();
                nextFileNumber = new ReferenceCodeSplit().splitFileNumber(nextFileNumber);
            }

            // 案件有多件
            if ((!fileNumber.equals(previousFileNumber) && fileNumber.equals(nextFileNumber))
                    || (fileNumber.equals(nextFileNumber))
                    || (fileNumber.equals(previousFileNumber) && !fileNumber.equals(nextFileNumber))) {
                filesNumberList.add(entriesList.get(i));

                if (!fileNumber.equals(nextFileNumber)) {
                    System.out.println(filesNumberList.toString());
                    // 页码解析
                    pagesNumberCheck(filesNumberList);
                    filesNumberList.clear();
                }
            }

            // 案卷仅有一件
            if (!fileNumber.equals(previousFileNumber) && !fileNumber.equals(nextFileNumber)) {
                filesNumberList.add(entriesList.get(i));
                System.out.println(filesNumberList.toString());
                pageNumberCheck(filesNumberList);
                filesNumberList.clear();
            }

        }

    }

    public void pageNumberCheck(List<Entry> fileNumberList) {
        if (!fileNumberList.get(0).getStartPageNumber().equals("1")) {
            System.out.println("起页号错误");
        } else {
            System.out.println("页号正确");
        }

    }

    public void pagesNumberCheck(List<Entry> filesNumberList) {

        // 解析页号
        int itemNumberStartPage = 0;
        int itemNumberEndPage = 0;
        int previousItemNumberStartPage = 0;
        int previousItemNumberEndPage = 0;
        int nextItemNumberStartPage = 0;
        int nextItemNumberEndPage = 0;

        for (int j = 0; j < filesNumberList.size(); j++) {
            itemNumberStartPage = Integer.parseInt(filesNumberList.get(j).getStartPageNumber());
            itemNumberEndPage = Integer.parseInt(filesNumberList.get(j).getEndPageNumber());
            if (j == 0) {
                previousItemNumberStartPage = 0;
                previousItemNumberEndPage = 0;
                nextItemNumberStartPage = Integer.parseInt(filesNumberList.get(j + 1).getStartPageNumber());
                nextItemNumberEndPage = Integer.parseInt(filesNumberList.get(j + 1).getEndPageNumber());

                if (itemNumberStartPage != 1) {
                    System.out.println(filesNumberList.get(j).getReferenceCode() + "\t起页号错误");
                } else if (itemNumberEndPage + 1 != nextItemNumberStartPage) {
                    System.out.println(filesNumberList.get(j).getReferenceCode() + "\t止页号错误");
                }
            } else if (j == filesNumberList.size() - 1) {
                previousItemNumberStartPage = Integer.parseInt(filesNumberList.get(j - 1).getStartPageNumber());
                previousItemNumberEndPage = Integer.parseInt(filesNumberList.get(j - 1).getEndPageNumber());
                nextItemNumberStartPage = 0;
                nextItemNumberEndPage = 0;

                if (itemNumberStartPage - 1 != previousItemNumberEndPage) {
                    System.out.println(filesNumberList.get(j).getReferenceCode() + "\t起页号错误");
                } else {
                    System.out.println("页号正确");
                }

            } else if (j != 1 && j != filesNumberList.size() - 1) {
                previousItemNumberStartPage = Integer.parseInt(filesNumberList.get(j - 1).getStartPageNumber());
                previousItemNumberEndPage = Integer.parseInt(filesNumberList.get(j - 1).getEndPageNumber());
                nextItemNumberStartPage = Integer.parseInt(filesNumberList.get(j + 1).getStartPageNumber());
                nextItemNumberEndPage = Integer.parseInt(filesNumberList.get(j + 1).getEndPageNumber());

                if (itemNumberStartPage - 1 != previousItemNumberEndPage) {
                    System.out.println(filesNumberList.get(j).getReferenceCode() + "\t起页号错误");
                } else if (itemNumberEndPage + 1 != nextItemNumberStartPage) {
                    System.out.println(filesNumberList.get(j).getReferenceCode() + "\t止页号错误");
                }

            }
        }

    }


}
