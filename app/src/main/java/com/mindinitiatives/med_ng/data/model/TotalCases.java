package com.mindinitiatives.med_ng.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalCases {

    @SerializedName("categories")
    @Expose
    private String categories;
    @SerializedName("values")
    @Expose
    private String values;

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "TotalCases{" +
                "categories='" + categories + '\'' +
                ", values=" + values +
                '}';
    }
}
