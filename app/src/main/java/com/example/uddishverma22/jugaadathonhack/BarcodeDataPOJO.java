package com.example.uddishverma22.jugaadathonhack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by uddishverma22 on 11/03/17.
 */

public class BarcodeDataPOJO {

    @SerializedName("PrintLetterBarcodeData")
    @Expose
    private AdharDetailsPOJO printLetterBarcodeData;

    public AdharDetailsPOJO getPrintLetterBarcodeData() {
        return printLetterBarcodeData;
    }

    public void setPrintLetterBarcodeData(AdharDetailsPOJO printLetterBarcodeData) {
        this.printLetterBarcodeData = printLetterBarcodeData;
    }


}
