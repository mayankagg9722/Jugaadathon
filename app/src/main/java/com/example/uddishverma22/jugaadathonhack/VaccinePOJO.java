package com.example.uddishverma22.jugaadathonhack;

/**
 * Created by uddishverma22 on 11/03/17.
 */

public class VaccinePOJO {

    Boolean bcg;
    Boolean dpt1;
    Boolean dpt2;
    Boolean dpt3;
    Boolean opv1;
    Boolean opv2;
    Boolean opv3;
    Boolean hbv1;
    Boolean hbv2;
    Boolean hbv3;
    Boolean measles;
    String date;

    public VaccinePOJO(Boolean bcg, Boolean dpt1, Boolean dpt2, Boolean dpt3, Boolean opv1, Boolean opv2,
                       Boolean opv3, Boolean hbv1, Boolean hbv2, Boolean hbv3, Boolean measles, String date) {
        this.bcg = bcg;
        this.dpt1 = dpt1;
        this.dpt2 = dpt2;
        this.dpt3 = dpt3;
        this.opv1 = opv1;
        this.opv2 = opv2;
        this.opv3 = opv3;
        this.hbv1 = hbv1;
        this.hbv2 = hbv2;
        this.hbv3 = hbv3;
        this.measles = measles;
        this.date = date;
    }


    public Boolean getBcg() {
        return bcg;
    }

    public void setBcg(Boolean bcg) {
        this.bcg = bcg;
    }

    public Boolean getDpt1() {
        return dpt1;
    }

    public void setDpt1(Boolean dpt1) {
        this.dpt1 = dpt1;
    }

    public Boolean getDpt2() {
        return dpt2;
    }

    public void setDpt2(Boolean dpt2) {
        this.dpt2 = dpt2;
    }

    public Boolean getDpt3() {
        return dpt3;
    }

    public void setDpt3(Boolean dpt3) {
        this.dpt3 = dpt3;
    }

    public Boolean getOpv1() {
        return opv1;
    }

    public void setOpv1(Boolean opv1) {
        this.opv1 = opv1;
    }

    public Boolean getOpv2() {
        return opv2;
    }

    public void setOpv2(Boolean opv2) {
        this.opv2 = opv2;
    }

    public Boolean getOpv3() {
        return opv3;
    }

    public void setOpv3(Boolean opv3) {
        this.opv3 = opv3;
    }

    public Boolean getHbv1() {
        return hbv1;
    }

    public void setHbv1(Boolean hbv1) {
        this.hbv1 = hbv1;
    }

    public Boolean getHbv2() {
        return hbv2;
    }

    public void setHbv2(Boolean hbv2) {
        this.hbv2 = hbv2;
    }

    public Boolean getHbv3() {
        return hbv3;
    }

    public void setHbv3(Boolean hbv3) {
        this.hbv3 = hbv3;
    }

    public Boolean getMeasles() {
        return measles;
    }

    public void setMeasles(Boolean measles) {
        this.measles = measles;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
