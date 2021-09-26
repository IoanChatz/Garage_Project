
package models;


public class Driver extends Human {

    public Driver(String idCard, String fName, String lName) {
        this.idCard = idCard;
        this.fName = fName;
        this.lName = lName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Diver with id: " + idCard + ", First Name: " + fName + ", Last name: " + lName ;
    }

 
    /*public void createDriver() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String checkInput;
        String idCard = null;
        String fName = null;
        String lName = null;
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
    }*/
    
    
    
}
