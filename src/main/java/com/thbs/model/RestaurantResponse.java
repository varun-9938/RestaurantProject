package com.thbs.model;

public class RestaurantResponse
{
    private String resname;
    private String resplace;
    private int resprice;
    private String imageString;

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname;
    }

    public String getResplace() {
        return resplace;
    }

    public void setResplace(String resplace) {
        this.resplace = resplace;
    }

    public int getResprice() {
        return resprice;
    }

    public void setResprice(int resprice) {
        this.resprice = resprice;
    }


    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    @Override
    public String toString() {
        return "RestaurantResponse{" +
                "resname='" + resname + '\'' +
                ", resplace='" + resplace + '\'' +
                ", resprice=" + resprice +
                ", ImageString='" + imageString + '\'' +
                '}';
    }
}
