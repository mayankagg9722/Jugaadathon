package com.example.uddishverma22.jugaadathonhack;

/**
 * Created by uddishverma22 on 11/03/17.
 */

public class VaccinePOJO {

    String  bcg;
    String dpt1;
    String dpt2;
    String dpt3;
    String opv1;
    String opv2;
    String opv3;
    String hbv1;
    String hbv2;
    String hbv3;
    String measles;

    public VaccinePOJO(String bcg, String dpt1, String dpt2, String dpt3, String opv1, String opv2,
                       String opv3, String hbv1, String hbv2, String hbv3, String measles) {

//        this.setBcg(bcg);
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
    }


    public String getBcg() {
        return bcg;
    }

    public void setBcg(String bcg) {
        this.bcg = bcg;
    }

    public String getDpt1() {
        return dpt1;
    }

    public void setDpt1(String dpt1) {
        this.dpt1 = dpt1;
    }

    public String getDpt2() {
        return dpt2;
    }

    public void setDpt2(String dpt2) {
        this.dpt2 = dpt2;
    }

    public String getDpt3() {
        return dpt3;
    }

    public void setDpt3(String dpt3) {
        this.dpt3 = dpt3;
    }

    public String getOpv1() {
        return opv1;
    }

    public void setOpv1(String opv1) {
        this.opv1 = opv1;
    }

    public String getOpv2() {
        return opv2;
    }

    public void setOpv2(String opv2) {
        this.opv2 = opv2;
    }

    public String getOpv3() {
        return opv3;
    }

    public void setOpv3(String opv3) {
        this.opv3 = opv3;
    }

    public String getHbv1() {
        return hbv1;
    }

    public void setHbv1(String hbv1) {
        this.hbv1 = hbv1;
    }

    public String getHbv2() {
        return hbv2;
    }

    public void setHbv2(String hbv2) {
        this.hbv2 = hbv2;
    }

    public String getHbv3() {
        return hbv3;
    }

    public void setHbv3(String hbv3) {
        this.hbv3 = hbv3;
    }

    public String getMeasles() {
        return measles;
    }

    public void setMeasles(String measles) {
        this.measles = measles;
    }

}
