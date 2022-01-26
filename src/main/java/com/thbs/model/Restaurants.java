package com.thbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Restaurant POJO class that has attributes for CRUD operations to be performed by admin
 * @author Priyanka_Ramesh
 */

@Entity
public class Restaurants
{
    @Id
    private int resid;
    private String resname;
    private String resplace;
    private int resprice;
    private int resstar;
    public byte[] image;

    public Restaurants() {
    }

    public Restaurants(int resid, String resname, String resplace, int resprice,int resstar) {
        this.resid = resid;
        this.resname = resname;
        this.resplace = resplace;
        this.resprice = resprice;
        this.resstar = resstar;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getResstar()
    {
        return resstar;
    }

    public void setResstar(int resstar) {
        this.resstar = resstar;
    }

    @Override
    public String toString() {
        return "restaurants{" +
                "resid=" + resid +
                ", resname='" + resname + '\'' +
                ", resplace='" + resplace + '\'' +
                ", resprice=" + resprice +
                ", resstar=" + resstar +
                '}';
    }
}