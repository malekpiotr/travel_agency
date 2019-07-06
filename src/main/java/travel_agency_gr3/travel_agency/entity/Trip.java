package travel_agency_gr3.travel_agency.entity;

import lombok.Getter;
import lombok.Setter;
import travel_agency_gr3.travel_agency.entity.FoodType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String destinationName;
    private Date dateOfDeparture;
    private Date dateOfReturn;
    private int numberOfDays;
    private FoodType foodType;
    private double addultPrice;
    private double childPrice;
    private int numberAdultPlaces;
    private int numberChildPlaces;
    private boolean promotion;

    public Trip() {
    }

    public Trip(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public double getAddultPrice() {
        return addultPrice;
    }

    public void setAddultPrice(double addultPrice) {
        this.addultPrice = addultPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public int getNumberAdultPlaces() {
        return numberAdultPlaces;
    }

    public void setNumberAdultPlaces(int numberAdultPlaces) {
        this.numberAdultPlaces = numberAdultPlaces;
    }

    public int getNumberChildPlaces() {
        return numberChildPlaces;
    }

    public void setNumberChildPlaces(int numberChildPlaces) {
        this.numberChildPlaces = numberChildPlaces;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
