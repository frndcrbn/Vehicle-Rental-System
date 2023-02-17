package vehiclerentalsystem;

import java.util.List;

public class RetalCompany {

    private List<Vehicle> vehicles;
    private List<Customer> customers;

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void rentVehicleToCustomers(String type, String model, Customer customer){
        Vehicle vehicleToCustomers = null;
        for (Vehicle v : vehicles){
            if (v.getMake().equals(type) && v.getModel().equals(model) && v.isAvailable()) {
                vehicleToCustomers = v;
                break;
            }
        }

        if (vehicleToCustomers != null){
            customer.addRentedVehicle(vehicleToCustomers);
            vehicleToCustomers.setAvailability(false);
            System.out.println("The vehicle (" + model + ") has been rented.");
        }else {
            System.out.println("This vehicle is not available.");
        }
    }

    public void returnVehicle(String type, String model, Customer customer){
        Vehicle vehicleToReturn = null;
        for (Vehicle v : customer.vehicleList()){
            if (v.getMake().equals(type) && v.getModel().equals(model)) {
                vehicleToReturn = v;
                break;
            }
        }

        if (vehicleToReturn != null){
            customer.returnVehicle(vehicleToReturn);
            vehicleToReturn.setAvailability(true);
        }else {
            System.out.println("The vehicle(" + model + ") is not on the list.");
        }
    }

    public void listOfVehicles(){
        if(vehicles.isEmpty()) {
            System.out.println("Vehicles are empty.");
        } else {
            System.out.println("List of Vehicles: ");
            for (Vehicle vehicle : vehicles){
                System.out.println("Vehicle:    " + vehicle.getMake());
                System.out.println("Model:      " + vehicle.getModel());
                System.out.println("Year:       " + vehicle.getYear());
                System.out.println("Available:  " + (vehicle.isAvailable() ? "Yes" : "No"));
            }
        }
    }

    public void listOfCustomers(){
        if (customers.isEmpty()){
            System.out.println("You have no customers left.");
        } else {
            System.out.println("List of Customers: ");
            for (Customer customer : customers){
                System.out.println("Name:       " + customer.getName());
                System.out.println("Address:    " + customer.getAddress());
                if (vehicles.isEmpty()){
                    System.out.println("Rented Vehicle: ");
                    System.out.println("Vehicle:    " + "---");
                    System.out.println("Model:      " + "---");
                    System.out.println("Year:       " + "---");
                } else {
                    System.out.println("Rented Vehicle: ");
                    for (Vehicle vehicle : vehicles){
                        System.out.println("Vehicle:    " + vehicle.getMake());
                        System.out.println("Model:      " + vehicle.getModel());
                        System.out.println("Year:       " + vehicle.getYear());
                    }
                }
            }
        }
    }
}
