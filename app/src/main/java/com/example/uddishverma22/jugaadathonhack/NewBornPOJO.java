package com.example.uddishverma22.jugaadathonhack;

/**
 * Created by uddishverma22 on 12/03/17.
 */

public class NewBornPOJO {

    String name;
    String dob;
    String aadhar;


    public NewBornPOJO(String name, String dob, String aadhar) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
