package org.scoula.smartSushi.domain;

public class SushiLogStat {
    private String plateColor;
    private int count;
    
    public SushiLogStat (String plateColor, int count) {
        this.plateColor = plateColor;
        this.count = count;
    }

    @Override
    public String toString () {
        return "최애 접시는 " + plateColor + "(" + count + "회)";
    }
}