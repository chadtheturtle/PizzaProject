package com.example;

public class PizzaObject {
    private String size;
    private String crustType;
    private Boolean hasMozzarella;
    private Boolean hasExtraMozzarella;


    private Boolean hasPepperoni;
    private Boolean hasExtraPepperoni;


    private Boolean hasOnion;
    private Boolean hasExtraOnion;
    private Boolean hasBellPepper;
    private Boolean hasExtraBellPepper;


    public PizzaObject(){

    }

public PizzaObject(String size, String crustType, Boolean hasMozzarella, Boolean hasExtraMozzarella, Boolean hasPepperoni, Boolean hasExtraPepperoni, Boolean hasOnion, Boolean hasExtraOnion, Boolean hasBellPepper, Boolean hasExtraBellPepper){
    this.size=size;
    this.crustType=crustType;
    this.hasMozzarella=hasMozzarella;
    this.hasExtraMozzarella=hasExtraMozzarella;
    this.hasPepperoni=hasPepperoni;
    this.hasExtraPepperoni=hasExtraPepperoni;
    this.hasOnion=hasOnion;
    this.hasExtraOnion=hasExtraOnion;
    this.hasBellPepper=hasBellPepper;
    this.hasExtraBellPepper=hasExtraBellPepper;
}


    public String getSize() {
        return size;
    }
    public String getCrustType() {
        return crustType;
    }

    public Boolean getHasMozzarella(){
        return hasMozzarella;
    }
    public Boolean getHasExtraMozzarella() {
        return hasExtraMozzarella;
    }

    public Boolean getHasPepperoni() {
        return hasPepperoni;
    }
    public Boolean getHasExtraPepperoni() {return hasExtraPepperoni; }

    public Boolean getHasBellPepper() {
        return hasBellPepper;
    }
    public Boolean getHasExtraBellPepper() {
        return hasExtraBellPepper;
    }

    public Boolean getHasOnion() {
        return hasOnion;
    }
    public Boolean getHasExtraOnion() {
        return hasExtraOnion;
    }



    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setHasBellPepper(Boolean hasBellPepper) {
        this.hasBellPepper = hasBellPepper;
    }

    public void setHasExtraBellPepper(Boolean hasExtraBellPepper) {
        this.hasExtraBellPepper = hasExtraBellPepper;
    }

    public void setHasExtraMozzarella(Boolean hasExtraMozzarella) {
        this.hasExtraMozzarella = hasExtraMozzarella;
    }

    public void setHasExtraOnion(Boolean hasExtraOnion) {
        this.hasExtraOnion = hasExtraOnion;
    }

    public void setHasExtraPepperoni(Boolean hasExtraPepperoni) {
        this.hasExtraPepperoni = hasExtraPepperoni;
    }

    public void setHasMozzarella(Boolean hasMozzarella) {
        this.hasMozzarella = hasMozzarella;
    }

    public void setHasOnion(Boolean hasOnion) {
        this.hasOnion = hasOnion;
    }

    public void setHasPepperoni(Boolean hasPepperoni) {
        this.hasPepperoni = hasPepperoni;
    }
}
