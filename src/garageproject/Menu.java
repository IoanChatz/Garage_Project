package garageproject;

import java.util.ArrayList;
import java.util.Scanner;
import models.GarageSpot;

public class Menu {

    boolean exit = false;
    GarageSpot gsp = new GarageSpot();
    double moneyFromCars = 0;
    ArrayList<GarageSpot> garageList = new ArrayList();
    
    public void welcomeMenuDetails(){
        System.out.println(":::::::::WELCOME TO GARAGE::::::::::");
        System.out.println("- Car cost 5€/hour.");
        System.out.println("- Motorcycle cost 5€/hour.");
        System.out.println("- First 30 minutes are free of charge.");
        System.out.println("- Garage has 10 total spots.\n");
    }

    public void printMainMenu() {
        System.out.println("---------- GARAGE MENU ----------");
        System.out.println("\nPlease make a Selection:");
        System.out.println("1.Insert a new Car into Garage.");
        System.out.println("2.Remove a Car from Garage.");
        System.out.println("3.Print total earned money.");
        System.out.println("4.Print the Staff in charge for a Car.");
        System.out.println("5.Fill Garage with Synthetic Data");
        System.out.println("0. For EXIT.");
    }

    private int getInput() {
        int selection = -1;
        Scanner sc = new Scanner(System.in);
        while (selection < 0 || selection > 5)
           try {
            System.out.print("\nInput your choice: ");
            selection = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Selection. Try again.");
        }
        return selection;
    }

    public void runMenu() {
        int garageSpots = 10;
        welcomeMenuDetails();
        while (!exit) {
            printMainMenu();
            int sel = getInput();
            switch (sel) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    if (garageList.size() < garageSpots) {
                        gsp.createSpot(garageList);
                    } else {
                        System.out.println("  ATTENTION!");
                        System.out.println("Garage is Full\n");
                    }
                    break;
                case 2:  
                    moneyFromCars +=gsp.removeVehicleFromSpot(garageList);
                    break;
                case 3:
                    gsp.totalMoneyNow(garageList, moneyFromCars);
                    break;
                case 4:
                    gsp.findStaffInCharge(garageList);
                    break;
                case 5:
                    if (garageList.size() < garageSpots) {
                        gsp.useSyntheticData(garageList,garageSpots);
                    } else {
                        System.out.println("  ATTENTION!");
                        System.out.println("Garage is Full\n");
                    }
                    break;
                default:
                    break;
            }

        }
    }

}
