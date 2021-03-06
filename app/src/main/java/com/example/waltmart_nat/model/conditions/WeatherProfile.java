
package com.example.waltmart_nat.model.conditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WeatherProfile implements Serializable
{

    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("current_observation")
    @Expose
    private CurrentObservation currentObservation;
    private final static long serialVersionUID = -4210492244672999115L;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

}
