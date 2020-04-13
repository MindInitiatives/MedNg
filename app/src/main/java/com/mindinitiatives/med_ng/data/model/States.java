package com.mindinitiatives.med_ng.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class States {

    @SerializedName("States")
    @Expose
    private String States;
    @SerializedName("No_of_cases")
    @Expose
    private Integer No_of_cases;
    @SerializedName("No_on_admission")
    @Expose
    private Integer No_on_admission;
    @SerializedName("No_discharged")
    @Expose
    private  Integer No_discharged;
    @SerializedName("No_of_deaths")
    @Expose
    private Integer No_of_deaths;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getStates() {
        return States;
    }

    public void setStates(String states) {
        States = states;
    }

    public Integer getNo_of_cases() {
        return No_of_cases;
    }

    public void setNo_of_cases(Integer no_of_cases) {
        No_of_cases = no_of_cases;
    }

    public Integer getNo_on_admission() {
        return No_on_admission;
    }

    public void setNo_on_admission(Integer no_on_admission) {
        No_on_admission = no_on_admission;
    }

    public Integer getNo_discharged() {
        return No_discharged;
    }

    public void setNo_discharged(Integer no_discharged) {
        No_discharged = no_discharged;
    }

    public Integer getNo_of_deaths() {
        return No_of_deaths;
    }

    public void setNo_of_deaths(Integer no_of_deaths) {
        No_of_deaths = no_of_deaths;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "States{" +
                "States='" + States + '\'' +
                ", No_of_cases=" + No_of_cases +
                ", No_on_admission=" + No_on_admission +
                ", No_discharged=" + No_discharged +
                ", No_of_deaths=" + No_of_deaths +
                ", id=" + id +
                '}';
    }
}
