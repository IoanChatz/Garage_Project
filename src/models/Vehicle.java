package models;


public class Vehicle {

    private String plateNumber;
    private Type type;

    public Vehicle(String plateNumber, Type type) {
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public Vehicle() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return" " + this.type + " with " + "Plate Number: " + plateNumber + ", Type: " + type;
    }

    /*public void createVehicle(ArrayList vehicleList) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String checkInput;
        String pNumber = null;
        String typeOf = null;
        while (!flag) {
            System.out.println("Please enter the Plate Number of the Vehicle.");
            checkInput = sc.nextLine().toUpperCase();
            if (isValid(checkInput)) {
                flag = true;
                pNumber = checkInput;
            } else {
                System.out.println("Invalid input.");
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
    }
 
    
    public boolean isValid(String str){
    String s1 =".*[A-Za-z_].*";
    String s2 =".*[0-9].*";
    return str.matches(s1) && str.matches(s2);
    }

    public <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.name().equals(value)) {
                return true;
            }
        }
        return false;
    }*/
}
