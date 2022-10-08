package com.loads.loads.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loadsa")
public class load {

    private long shipperId;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private long noOfTrucks;
    private long weight;
    private String comment;
    private String date;

    public load() {

    }

    public load(String loadingPoint, String unloadingPoint, String productType, String truckType, long noOfTrucks,
            long weight, String comment, String date) {
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.comment = comment;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getShipperId() {
        return shipperId;
    }

    public void setShipperId(long shipperId) {
        this.shipperId = shipperId;
    }

    @Column(name = "loadingPoint", nullable = false)
    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    @Column(name = "unloadingPoint", nullable = false)
    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    @Column(name = "productType", nullable = false)
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Column(name = "truckType", nullable = false)
    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    @Column(name = "noOfTrucks", nullable = false)
    public long getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(long noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    @Column(name = "weight", nullable = false)
    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Column(name = "comment", nullable = true)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "date", nullable = false)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "load [shipperId=" + shipperId + ", loadingPoint=" + loadingPoint + ", unloadingPoint=" + unloadingPoint
                + ", productType=" + productType + ", truckType=" + truckType + ", noOfTrucks=" + noOfTrucks
                + ", weight=" + weight + ", comment=" + comment + ", date=" + date + "]";
    }
}