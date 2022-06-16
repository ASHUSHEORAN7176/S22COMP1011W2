package com.example.s22comp1011w2;

import java.util.Arrays;
import java.util.List;

public class Phone {
    private String make,model,os;
    private  int ram,backCameraMP;
    private double price;
    private int batteryLifeInHours, quantityInStock;

    /**
     * this is a standard constructor  - weneed all of these to built an Phone Object
     * @param make - Apple, Samsung, HTC etc....
     * @param model iPone,Galaxy etc....
     * @param os - The Operating System (Android,IOs)
     * @param ram - how much ram is in the Phone
     * @param backCameraMP The Mega Pixels Of Rear Main Camera
     * @param price price of phone
     * @param batteryLifeInHours simply battery life
     * @param quantityInStock stock units available
     */
    public Phone(String make, String model, String os, int ram, int backCameraMP, double price, int batteryLifeInHours, int quantityInStock) {
        setMake(make);
        setModel(model);
        setOs(os);
        setRam(ram);
        setBackCameraMP(backCameraMP);
        setPrice(price);
        setBatteryLifeInHours(batteryLifeInHours);
        setQuantityInStock(quantityInStock);
    }

    /**)
     * this Will Set manufacture or make of phone
     * @param make
     */
    public void setMake(String make) {
        List<String> manufacturers =(Arrays.asList("Apple","SamSung","Nokia","Realme","Oppo","Vivo","Blackberry","HTC","Huawei","Motorola","Google"));
        if (manufacturers.contains(make))
            this.make=make;
        else
            throw new IllegalArgumentException(make + "is not Valid, choose  from" + manufacturers);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        model = model.trim();
        if(model.length()>=2)
            this.model = model;
        else
            throw new IllegalArgumentException("Invalid model, must be be 2 or more characters");
    }

    public String getOs() {
        return os;
    }

    /**
     * setOs defines the operating sysstem for the phone
     * @param os must ne iOs  or Android
     */

    public void setOs(String os) {

        if (os.equalsIgnoreCase("iOS"))
             this.os = "iOS";
        else if (os.equalsIgnoreCase("android"))
            this.os = "Android";
        else
            throw new IllegalArgumentException("os must be iOS or  Android");

    }

    public int getRam() {
        return ram;
    }

    /**
     * How amny gigs of memory on the phone
     * @param ram - 64.......
     */

    public void setRam(int ram) {
        if (ram == 64 || ram == 128 || ram==512)
            this.ram = ram;
        else
            throw new IllegalArgumentException("Ram must be 64, 128, 256 or 512");
    }

    public int getBackCameraMP() {
        return backCameraMP;
    }

    /**
     * Teh MegaPixel capacity of the rear main camera
     * @param backCameraMP - must be greater than 0
     */

    public void setBackCameraMP(int backCameraMP) {
        if (backCameraMP>0)
            this.backCameraMP = backCameraMP;
        else
            throw new IllegalArgumentException("back camera MP msut be grater than '0'");
    }

    public double getPrice() {
        return price;
    }

    /** This is the MSRP ( manufacturer sugggesteg ratail price)
     * @param price - grater than or equal to 0
     */

    public void setPrice(double price) {
        if (price >=0)
             this.price = price;
        else
            throw new IllegalArgumentException("Price must be grater than 0");
    }

    public int getBatteryLifeInHours() {
        return batteryLifeInHours;
    }


    /**
     * how long phone should lasat with moderat e use between
     * @param batteryLifeInHours >0 to 240
     */
    public void setBatteryLifeInHours(int batteryLifeInHours) {
        if (batteryLifeInHours >0 && batteryLifeInHours<=240)
            this.batteryLifeInHours = batteryLifeInHours;
        else
            throw new IllegalArgumentException("battery life must be between 0 to 240 ");
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock>=0)
           this.quantityInStock = quantityInStock;
        else
            throw new IllegalArgumentException("quantity in stock must be 0 or higher ");
    }

    public int sellPhone(int numberSold){
        if (numberSold>quantityInStock){
            numberSold = quantityInStock;
            quantityInStock=0;
        }else{
            quantityInStock -= numberSold;
        }
        return numberSold;
    }

    public void reciveInventory(int numOfNewPhones){
        quantityInStock += numOfNewPhones;
    }
}
