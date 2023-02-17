package vehiclerentalsystem;

public class Vehicle {

    private String make, model;
    private int year;
    private boolean availability;

    Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
        this.availability = true;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public boolean isAvailable(){
        return availability;
    }

    public void setAvailability(boolean availability){
        this.availability = availability;
    }

}
