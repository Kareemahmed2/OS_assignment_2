import java.util.*;

public class ParkingLot {
    int totalSlots = 4;
    private int currentlyParked = 0;
    private int totalServed = 0;
    private final Object lock = new Object();
    Semaphore avialbleSlots = new Semaphore(totalSlots);
    //Semaphore waitingList = new Semaphore(0);
List<Car> waitingList=new ArrayList<>();

    public void park(Car car) throws InterruptedException
    {
        synchronized (lock)
        {
            System.out.printf("Car %d from Gate "+car.getGate() + " arrived at time %d\n", car.getCarID(),car.getArrival_time());
        }
        avialbleSlots.P(); //decrease the slots and if their no spots make the threads wait for notifying
        synchronized (lock)
        {
            currentlyParked++;
            System.out.printf("Car %d from Gate " +car.getGate() + " parked. (Parking Status: %d spots occupied)\n",car.getCarID(),currentlyParked);

        }
        Thread.sleep(car.getParking_duration()*1000L);
        synchronized (lock) {
            currentlyParked--;
            totalServed++;
            System.out.printf("Car %d left. (Currently parked: %d)\n", car.getCarID(), currentlyParked);
        }
        avialbleSlots.V(); // Release the parking spot


    }

}
