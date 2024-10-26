package com.web.lab.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String brand, model, color, numberRegister;
    private int year_, price;

    public Car(){

    }

    public Car(String brand, String model, String color, String numberRegister, int year_, int price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.numberRegister = numberRegister;
        this.year_ = year_;
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	private Owner owner;

	//Getter  and  setter
	public Owner getOwner()  {
	    return owner;
	}

	public void setOwner(Owner owner)  {
	    this.owner = owner;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumberRegister() {
        return numberRegister;
    }

    public void setNumberRegister(String numberRegister) {
        this.numberRegister = numberRegister;
    }

    public int getYear() {
        return year_;
    }

    public void setYear(int year) {
        this.year_ = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
