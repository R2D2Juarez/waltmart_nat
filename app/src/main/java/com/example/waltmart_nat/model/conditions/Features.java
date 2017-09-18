
package com.example.waltmart_nat.model.conditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Features implements Serializable
{

    @SerializedName("conditions")
    @Expose
    private Integer conditions;
    private final static long serialVersionUID = -1417049007486611046L;

    public Integer getConditions() {
        return conditions;
    }

    public void setConditions(Integer conditions) {
        this.conditions = conditions;
    }

}
