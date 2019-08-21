package com.allan.laptopgaming.Model;

import java.io.Serializable;

public class Laptop implements Serializable {
    private String laptopName, laptopSpec, laptopPrice, laptopComment, laptopImage;

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getLaptopSpec() {
        return laptopSpec;
    }

    public void setLaptopSpec(String laptopSpec) {
        this.laptopSpec = laptopSpec;
    }

    public String getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(String laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    public String getLaptopComment() {
        return laptopComment;
    }

    public void setLaptopComment(String laptopComment) {
        this.laptopComment = laptopComment;
    }

    public String getLaptopImage() {
        return laptopImage;
    }

    public void setLaptopImage(String laptopImage) {
        this.laptopImage = laptopImage;
    }
}
