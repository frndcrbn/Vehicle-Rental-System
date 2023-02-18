package vehiclerentalsystem;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        RentalCompany company = new RentalCompany();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("[1] Add Vehicle.");
            System.out.println("[2] Add Customer.");
            System.out.println("[3] Rent Vehicle.");
            System.out.println("[4] Return Vehicle.");
            System.out.println("[5] Display All Vehicle.");
            System.out.println("[6] Display All Customers.");
            System.out.println("[0] Exit.");
            System.out.print("Select here: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("#ADD VEHICLE");
                    System.out.print("Enter type: ");
                    String type = scanner.next();
                    System.out.print("Enter model: ");
                    String model = scanner.next();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    company.addVehicle(new Vehicle(type, model, year));
                    System.out.println("Vehicle added!");
                    break;
                case 2:
                    System.out.println("#ADD CUSTOMER");
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter address: ");
                    String address = scanner.next();
                    company.addCustomer(new Customer(name, address));
                    System.out.println("Customer added!");
                    break;
                case 3:
                    System.out.println("#RENT VEHICLE");
                    System.out.print("Enter type: ");
                    type = scanner.next();
                    System.out.print("Enter model: ");
                    model = scanner.next();
                    System.out.print("Enter Customer(name): ");
                    name = scanner.next();
//                    Vehicle vehicle = company.getVehicles().stream().filter(v -> v.getMake().equals(type) && v.getModel().equals(model)).findFirst().orElse(null);
                    Customer customer = company.getCustomers().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
                    if( customer != null ){
                        company.rentVehicleToCustomers(type, model, customer);
                        System.out.println("Vehicle Rented!");
                    }else {
                        System.out.println("This vehicle/customer does not exist.");
                    }
                    break;
                case 4:
                    System.out.println("#RETURN VEHICLE");
                    System.out.print("Enter type: ");
                    type = scanner.next();
                    System.out.print("Enter model: ");
                    model = scanner.next();
                    System.out.print("Enter Customer(name): ");
                    name = scanner.next();
                    customer = company.getCustomers().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
                    if( customer != null ){
                        company.returnVehicle(type, model, customer);
                        System.out.println("Vehicle Returned!");
                    }else {
                        System.out.println("This vehicle/customer does not exist.");
                    }
                    break;
                case 5:
                    System.out.println("#LIST OF VEHICLES");
                    company.listOfVehicles();
                    break;
                case 6:
                    System.out.println("#LIST OF CUSTOMERS");
                    company.listOfCustomers();
                    break;
                case 0:
                    System.out.println("Thank you for using us.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select of the choices only.");
                    break;
            }
        }
    }
}
