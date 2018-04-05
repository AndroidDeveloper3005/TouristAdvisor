package com.himel.androiddeveloper3005.touristadvisor.model;

import java.io.Serializable;

public class Hotels implements Serializable {

    private String pname;
    private String hname;
    private String address;
    private String price;
    private String image_url;

    public Hotels(String pname, String hname, String address, String price, String image_url) {
        this.pname = pname;
        this.hname = hname;
        this.address = address;
        this.price = price;
        this.image_url = image_url;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}
