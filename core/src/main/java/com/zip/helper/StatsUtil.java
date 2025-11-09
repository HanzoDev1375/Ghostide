package com.zip.helper;

import java.util.Map;
import java.util.zip.ZipEntry;

public class StatsUtil {

    private int numToBeExtracted = 0;
    private long totalSizeToBeExtracted = 0;

    private StatsUtil() {
    }

    public static StatsUtil getInstance() {
        return new StatsUtil();
    }

    public int getNumToBeExtracted() {
        return numToBeExtracted;
    }

    public long getTotalSizeToBeExtracted() {
        return totalSizeToBeExtracted;
    }

    public void retrieveToBeExtractedStats(Map<String, Object> entries) {
        for (Map.Entry<String, Object> entry : entries.entrySet()) {
            if (entry.getValue() instanceof ZipEntry) {
                ZipEntry zipEntry = (ZipEntry) entry.getValue();
                numToBeExtracted++;
                totalSizeToBeExtracted += zipEntry.getSize();
            } else {
                if (!"..".equals(entry.getKey())) {
                    retrieveToBeExtractedStats((Map<String, Object>) entry.getValue());
                }
            }
        }
    }
}
