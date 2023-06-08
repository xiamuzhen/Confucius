package com.hopes.template;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.List;

public class DemoDataListener implements ReadListener<Entry> {
    List<Entry> list = new ArrayList<>();

    @Override
    public void invoke(Entry archivesEntity, AnalysisContext analysisContext) {
        list.add(archivesEntity);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
