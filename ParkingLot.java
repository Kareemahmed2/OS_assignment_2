





import java.util.*;

public class ParkingLot {
    int totalSlots = 4;
    private int currentlyParked = 0;
    private int totalServed = 0;
    private final Object lock = new Object();
    Semaphore avialbleSlots = new Semaphore(totalSlots);
    int currTime=0;
int totalCars=0;
    List<Gate> gates=new ArrayList<>(); //Sami
    public ParkingLot(int cars)
     { totalCars=cars;
        for(int i=0;i<3;i++) gates.add(new Gate(i)); // make for every gate an array

    }




    // Method for a car to be ina gate  and park
    public void chooseGateAndPark() throws InterruptedException {
     while(totalCars!=0)
     {
    for(Gate g:gates) {
        if (g.getCars().getFirst().getArrival_time() == currTime) {
            if (parkCar(g.getCars().getFirst())) {
                g.getCars().removeFirst();

            }
        }
    }


     currTime++;
     }











//        int index=car.getGate().getGateNumber()-1; //gate number
//        gates.get(index).addCarToList(car); //to the gate it belong
//        if(hasSameArrivalTime(car)) //only for the prioritization
//        {
//            parkCar(gates.get(0)); // Gate 1 first
//            parkCar(gates.get(1)); // Then Gate 2
//            parkCar(gates.get(2)); // then 3
//        }
//        else
//        {
//            for (Gate gate : gates) { //park with the same sequence
//                parkCar(gate);
//            }
//        }
//        /*int time=0;
//        int max_arrival_time=20;
//        while((time == car.getArrival_time()) || (time < max_arrival_time))
//        {
//            if (index == 0) gates.get(0).addCarToList(car);
//            else if (index == 1) gates.get(1).addCarToList(car);
//            else if (index == 2) gates.get(2).addCarToList(car);
//            time++;
//        }*/

//        if(index==0)
//        {OrderCars(gates.get(0).getCars().getFirst());}
//        else if(index==1){OrderCars(gates.get(1).getCars().getFirst());}
//        else if(index==2){OrderCars(gates.get(2).getCars().getFirst());}


    }
    private boolean hasSameArrivalTime(Car car) //check if their are two cars with same arrivaltime in different gate
    {
        int arrivalTime=car.getArrival_time();
//
//        for(Gate gate:gates)
//        {
////            for(Car otherCar:gate.getCars())
////            {
////                if(car!=otherCar&&otherCar.getArrival_time()==arrivalTime)return true;
////            }
//
//        }
//        return false;

        if(arrivalTime==currTime)return true;
        else return false;

    }

//public void OrderCars(Car car) throws InterruptedException {
//    while (!((gates.get(0).getCars().isEmpty()) && gates.get(1).getCars().isEmpty() && gates.get(2).getCars().isEmpty()))
//    {
//        if (car.getGate().getGateNumber() == 1) {
//            parkCar(car);
//            gates.get(0).getCars().removeFirst();
//        } else if (car.getGate().getGateNumber() == 2) {
//            parkCar(car);
//            gates.get(1).getCars().removeFirst();
//        } else if (car.getGate().getGateNumber() == 3) {
//            parkCar(car);
//            gates.get(2).getCars().removeFirst();
//        }
//    }
//}

    public boolean parkCar(Car car) throws InterruptedException { //park the car

        boolean flag= false;
            synchronized (lock) {
                System.out.printf("Car %d from Gate   arrived at time %d\n", car.getGate().getGateNumber(), car.getCarID(), car.getArrival_time());
            }

            avialbleSlots.P(car); //decrease the slots and if their no spots make the threads wait for notifying
            synchronized (lock) {
                currentlyParked++;
                System.out.printf("Car %d from Gate   parked. (Parking Status: %d spots occupied)\n", car.getGate().getGateNumber(), car.getCarID(), currentlyParked);
               flag=true;
            }
            Thread.sleep(car.getParking_duration() * 1000L);
            synchronized (lock) {
                currentlyParked--;
                totalServed++;
                System.out.printf("Car %d left. (Currently parked: %d)\n", car.getCarID(), currentlyParked);
            }
            avialbleSlots.V(); // Release the parking spot
                               //           gate.getCars().remove(0);


return flag;
    }
    public int getTotalServed() {
        return totalServed;
    }
}








