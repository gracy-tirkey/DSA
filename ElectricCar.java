// class Automobile {
//     private String drive(){
//         return "Driving Vehicle";
//     } 
// }
// public class Car extends Automobile {
class Car{
    protected String drive(){
        return "Driving Car";
    }
}

public class ElectricCar extends Car{
    @Override
    public final String drive(){
        return "Driving Electric car";
    }

    public static void main(String[] args) {
        final Car car = new ElectricCar();
        System.out.println(car.drive());

        // Automobile a = new Car();
        
        // System.out.println(a.drive()); //Error
    }
}

