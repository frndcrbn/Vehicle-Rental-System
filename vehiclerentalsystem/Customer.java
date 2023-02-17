package vehiclerentalsystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name, address;
    private List<Vehicle> rentedVehicles;

    Customer(String name, String address){
        this.name = name;
        this.address = address;
        this.rentedVehicles = new ArrayList<>();
    }

    public String getName(){
        return  name;
    }

    public String getAddress(){
        return address;
    }

    public void addRentedVehicle(Vehicle vehicle){
        rentedVehicles.add(vehicle);
    }

    public void returnVehicle(Vehicle vehicle){
        rentedVehicles.remove(vehicle);
    }

    public List<Vehicle> vehicleList(){
        return rentedVehicles;
    }
}
