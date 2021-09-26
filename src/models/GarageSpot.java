
package models;

import java.util.ArrayList;
import java.util.Scanner;

public class GarageSpot {

    private Driver driver;
    private Staff staff;
    private Vehicle vehicle;
    private String startPark;

//Constructors------------------------------------------
    public GarageSpot(Driver driver, Staff staff, Vehicle vehicle, String startPark) {
        this.driver = driver;
        this.staff = staff;
        this.vehicle = vehicle;
        this.startPark = startPark;
    }

    public GarageSpot() {
    }
//Getters & Setters-------------------------------------

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "GarageSpot " + driver + staff + vehicle + this.startPark;
    }

//Methods to validate the inputs from the user---------------------
    public boolean validName(String str) {
        String s1 = "[a-zA-Z]+";
        return str.matches(s1);
    }

    public boolean isValid(String str) {
        String s1 = ".*[A-Za-z_].*";
        String s2 = ".*[0-9].*";
        return str.matches(s1) && str.matches(s2);
    }

    public <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.name().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPlate(ArrayList<GarageSpot> garageList, String checkInput) {
        boolean exists = false;
        for (GarageSpot garageSpot : garageList) {
            if (garageSpot.getVehicle().getPlateNumber().equals(checkInput)) {
                exists = true;
            }
        }
        return exists;
    }

//Method to add to the GarageList-------------------------------- 
    public void createSpot(ArrayList<GarageSpot> garageList) {
        Scanner sc = new Scanner(System.in);
        TimePark time = new TimePark();
        boolean flag = false;
        String pNumber = null;
        String typeOf = null;
        String checkInput;
        String idCard = null;
        String fName = null;
        String lName = null;
        String sfName = null;
        String slName = null;
        while (!flag) {
            System.out.println("Please type the ID of the Driver.");
            checkInput = sc.nextLine().toUpperCase();
            if (isValid(checkInput)) {
                flag = true;
                idCard = checkInput;
            } else {
                System.out.println("Invalid input.");
                System.out.println("Please try again.");
            }
        }
        flag = false;
        while (!flag) {
            System.out.println("Please type Driver's First Name.");
            checkInput = sc.nextLine().toUpperCase();
            if (validName(checkInput)) {
                flag = true;
                fName = checkInput;
            } else {
                System.out.println("Invalid input.");
                System.out.println("Please try again.");
            }
        }
        flag = false;
        while (!flag) {
            System.out.println("Please type Driver's Last Name.");
            checkInput = sc.nextLine().toUpperCase();
            if (validName(checkInput)) {
                flag = true;
                lName = checkInput;
            } else {
                System.out.println("Invalid input.");
                System.out.println("Please try again.");
            }
        }
        flag = false;
        while (!flag) {
            System.out.println("Please type the First Name of the staff who is in charge.");
            checkInput = sc.nextLine().toUpperCase();
            if (validName(checkInput)) {
                flag = true;
                sfName = checkInput;
            } else {
                System.out.println("Invalid input.");
                System.out.println("Please try again.");
            }
        }
        flag = false;
        while (!flag) {
            System.out.println("Please type the Last Name of the staff who is in charge.");
            checkInput = sc.nextLine().toUpperCase();
            if (validName(checkInput)) {
                flag = true;
                slName = checkInput;
            } else {
                System.out.println("Invalid input.");
                System.out.println("Please try again.");
            }
        }
        flag = false;
        while (!flag) {
            System.out.println("Please enter the Plate Number of the Vehicle.");
            checkInput = sc.nextLine().toUpperCase();
            if (isValid(checkInput) && !checkPlate(garageList, checkInput)) {
                flag = true;
                pNumber = checkInput;

            } else {
                System.out.println("Invalid input or already exists.");
                System.out.println("Please try again.");
            }
        }
        flag = false;
        while (!flag) {
            System.out.println("Please type the kind of Vehicle CAR or MOTORCYCLE.");
            checkInput = sc.nextLine().toUpperCase();
            if (isInEnum(checkInput, Type.class)) {
                flag = true;
                typeOf = checkInput;
            } else {
                System.out.println("Invalid input.");
                System.out.println("Please try again.");
            }
        }
        garageList.add(new GarageSpot(new Driver(idCard, fName, lName), new Staff(sfName, slName), new Vehicle(pNumber, Type.valueOf(typeOf)), time.startPark()));
    }

//Method to find the Staff in charge for a spesific car by Plate Number---------------------------   
    public void findStaffInCharge(ArrayList<GarageSpot> garageList) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        System.out.println("Please type the plate number of the car.");
        String plateN = sc.nextLine().toUpperCase();
        for (GarageSpot garageSpot : garageList) {
            if (garageSpot.getVehicle().getPlateNumber().equals(plateN)) {
                System.out.println("The person in charge for this car is: " + garageSpot.getStaff().fName + " " + garageSpot.getStaff().lName);
                found = true;
                break;
            } else {
                found = false;
            }
        }
        if (found == true) {
        } else {
            System.out.println("This plate number doesn't exist.");
        }
    }

//Method to remove a Vehicle from the Garage List-------------------------------------------    
    public double removeVehicleFromSpot(ArrayList<GarageSpot> garageList) {
        TimePark time = new TimePark();
        Scanner sc = new Scanner(System.in);
        String spotStart = null;
        String spotEnd = null;
        String typeOfVehicle = null;
        long totalTime = 0;
        double cost = 0;
        boolean found = false;
        System.out.println("Please type the the plate number of the car that is exiting");
        String plateN = sc.nextLine().toUpperCase();
        for (GarageSpot garageSpot : garageList) {
            if (garageSpot.getVehicle().getPlateNumber().equals(plateN)) {
                spotStart = garageSpot.startPark;
                spotEnd = time.endPark();
                typeOfVehicle = garageSpot.getVehicle().getType().toString();
                garageList.remove(garageSpot);
                garageList.trimToSize();
                System.out.println("\nThe Garage spot is empty now.");
                System.out.println("Current empty spots in the Garage: " + (10 - garageList.size()));
                found = true;
                totalTime = time.findDifference(spotStart, spotEnd);
                break;
            }
        }
        if (typeOfVehicle == "CAR") {
            cost = time.carRate(totalTime);
            System.out.println("The cost was: " + cost + " €\n");
        } else if (typeOfVehicle == "MOTORCYCLE") {
            cost = time.motorcycleRate(totalTime);
            System.out.println("The cost was: " + cost + " €\n");
        } else {
            System.out.println("The Plate Number you are looking doesn't exist!");
        }
        return cost;
    }
    
//Method to find out the total earning made depending on the current time------------
    public void totalMoneyNow(ArrayList<GarageSpot> garageList, double cost) {
        TimePark time = new TimePark();
        String spotStart = null;
        String spotEnd = null;
        double totalMoney = 0;
        long totalTime;
        for (GarageSpot garageSpot : garageList) {
            spotStart = garageSpot.startPark;
            spotEnd = time.endPark();
            totalTime = time.findDifference(spotStart, spotEnd);
            if (garageSpot.getVehicle().getType().toString() == "CAR") {
                
                totalMoney += time.carRate(totalTime);
            } else {
                totalMoney += time.motorcycleRate(totalTime);
            }
        }
        System.out.println("The garage has made till now " + (totalMoney + cost) + " € .");
    }
    
//A Method to fill the Garage List with Synthetic data-----------------------------------------
    public void useSyntheticData(ArrayList<GarageSpot> garageList, int garageSpots) {
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AE 550144", "Olivia", "Rawlings"), new Staff("Max", "Reeves"), new Vehicle("IOA 5471", Type.CAR), "25-09-2021 18:05:00"));
        } else {
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AE 545144", "William", "Crawford"), new Staff("George", "Miles"), new Vehicle("YOT 5471", Type.MOTORCYCLE), "25-09-2021 19:05:00"));
        } else {
            System.out.println("One new entry was made.");
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AE 533174", "John", "Rawlings"), new Staff("Daniel", "Wiggins"), new Vehicle("IHH 6170", Type.CAR), "25-09-2021 19:15:00"));
        } else {
            System.out.println("Two new entries were made.");
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AI 150184", "Sophia", "Musk"), new Staff("George", "Miles"), new Vehicle("YTT 8989", Type.MOTORCYCLE), "25-09-2021 19:33:00"));
        } else {
            System.out.println("Three new entries were made.");
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AE 500163", "James", "Phillips"), new Staff("David", "Fischer"), new Vehicle("YOT 4787", Type.CAR), "25-09-2021 20:05:00"));
        } else {
            System.out.println("Four new entries were made.");
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AA 350155", "Ethan", "Jobs"), new Staff("Michael", "Anderson"), new Vehicle("IAA 4443", Type.CAR), "25-09-2021 20:35:00"));
        } else {
            System.out.println("Five new entries were made.");
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AE 577149", "Alexander", "Gates"), new Staff("Max", "Reeves"), new Vehicle("AXA 6471", Type.MOTORCYCLE), "25-09-2021 21:05:00"));
        } else {
            System.out.println("Six new entries were made.");
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AE 893662", "Paul", "Torvalds"), new Staff("David", "Fischer"), new Vehicle("KIE 5551", Type.MOTORCYCLE), "25-09-2021 22:08:00"));
        } else {
            System.out.println("Seven new entries were made.");
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AE 578884", "Richard", "Hopper"), new Staff("Michael", "Anderson"), new Vehicle("EGB 5889", Type.CAR), "25-09-2021 22:37:00"));
        } else {
            System.out.println("Eight new entries were made.");
            System.out.println("Garage is Full\n");
            return;
        }
        if (garageList.size() < garageSpots) {
            garageList.add(new GarageSpot(new Driver("AE 577144", "Leonidas", "Smith"), new Staff("George", "Miles"), new Vehicle("YYI 5477", Type.CAR), "25-09-2021 22:41:00"));
        } else {
            System.out.println("Nine new entries were made.");
            System.out.println("Garage is Full\n");
            return;
        }
        System.out.println(garageList);
    }

}
