package oca.m5l8;

public class Asset {
    private int value;

    public Asset(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void applyAnnualDepreciation(){
        value = 8 * value / 10;
    }
}
