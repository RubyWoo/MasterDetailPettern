package com.example.masterdetailpettern;

import java.io.Serializable;

public class PaisajeVo implements Serializable {

    private String nameCity;
    private String information;
    private String descriptionDetails;
    private int imageResource;
    private int imageResourceDetails;

    PaisajeVo(){}

    PaisajeVo(String nameCity, String information, int imageResource){
        this.nameCity = nameCity;
        this.information = information;
        this.imageResource = imageResource;

    }

    public PaisajeVo(String nameCity, String information, String descriptionDetails, int imageResource, int imageResourceDetails) {
        this.nameCity = nameCity;
        this.information = information;
        this.descriptionDetails = descriptionDetails;
        this.imageResource = imageResource;
        this.imageResourceDetails = imageResourceDetails;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getDescriptionDetails() {
        return descriptionDetails;
    }

    public void setDescriptionDetails(String descriptionDetails) {
        this.descriptionDetails = descriptionDetails;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageResourceDetails() {
        return imageResourceDetails;
    }

    public void setImageResourceDetails(int imageResourceDetails) {
        this.imageResourceDetails = imageResourceDetails;
    }
}
