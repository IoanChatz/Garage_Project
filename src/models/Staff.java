
package models;

public class Staff extends Human {

    public Staff(String fName, String lName) {;
        this.fName = fName;
        this.lName = lName;
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
        return " Staff with First Name: " + fName + ", Last name: " + lName;
    }

   
    /*public void createStaff() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String checkInput;
        String idCard = null;
        String sfName = null;
        String slName = null;
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
    }*/
}
