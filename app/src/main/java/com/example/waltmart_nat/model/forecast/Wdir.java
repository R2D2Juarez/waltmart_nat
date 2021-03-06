
package com.example.waltmart_nat.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Wdir implements Serializable
{

    @SerializedName("dir")
    @Expose
    private String dir;
    @SerializedName("degrees")
    @Expose
    private String degrees;
    private final static long serialVersionUID = 5311011614324214783L;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

}
