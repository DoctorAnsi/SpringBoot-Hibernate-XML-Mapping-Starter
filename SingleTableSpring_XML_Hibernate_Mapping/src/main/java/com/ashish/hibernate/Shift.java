package com.ashish.hibernate;

import java.io.Serializable;

public class Shift implements Serializable {
    private String shiftName;
    private Integer shiftId;
    private String shiftAttr1;

    public Shift() {
    }

    private Integer shiftAttr2;

    public Shift(String shiftName, String shiftAttr1, Integer shiftAttr2) {
        this.shiftName = shiftName;
        this.shiftAttr1 = shiftAttr1;
        this.shiftAttr2 = shiftAttr2;
    }

    public Shift(String shiftName, Integer shiftId, String shiftAttr1, Integer shiftAttr2) {
        this.shiftName = shiftName;
        this.shiftId = shiftId;
        this.shiftAttr1 = shiftAttr1;
        this.shiftAttr2 = shiftAttr2;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftAttr1() {
        return shiftAttr1;
    }

    public void setShiftAttr1(String shiftAttr1) {
        this.shiftAttr1 = shiftAttr1;
    }

    public Integer getShiftAttr2() {
        return shiftAttr2;
    }

    public void setShiftAttr2(Integer shiftAttr2) {
        this.shiftAttr2 = shiftAttr2;
    }
}
