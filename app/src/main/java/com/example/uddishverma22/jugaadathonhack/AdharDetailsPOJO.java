package com.example.uddishverma22.jugaadathonhack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by uddishverma22 on 11/03/17.
 */

public class AdharDetailsPOJO {

    @SerializedName("pc")
    @Expose
    private Integer pc;
    @SerializedName("uid")
    @Expose
    private Long uid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("co")
    @Expose
    private String co;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("yob")
    @Expose
    private Integer yob;
    @SerializedName("dist")
    @Expose
    private String dist;
    @SerializedName("vtc")
    @Expose
    private String vtc;

    public Integer getPc() {
        return pc;
    }

    public void setPc(Integer pc) {
        this.pc = pc;
    }

    public Long getUID() {
        return uid;
    }

    public void setUID(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getYob() {
        return yob;
    }

    public void setYob(Integer yob) {
        this.yob = yob;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getVtc() {
        return vtc;
    }

    public void setVtc(String vtc) {
        this.vtc = vtc;
    }
}
