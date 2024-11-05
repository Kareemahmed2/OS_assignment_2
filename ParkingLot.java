import java.util.*;

public class ParkingLot
{
int totalSlots=4 ;
private int currentlyParked = 0;
private int totalServed = 0;
    private final Object lock = new Object();
Semaphore avialbleSlots = new Semaphore(totalSlots) ;
List<Car> waitingList=new ArrayList<>();

public void park(Car car)  throws  InterruptedException
{
synchronized (lock)
{
 System.out.printf("Car %d from Gate "+car.getGate() + " arrived at time %d\n", car.getCarID(),car.getArrival_time());
}
if(avialbleSlots.tryAcquire())
{
avialbleSlots.P();
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
    lock.notifyAll();
}

    else
                       {
          synchronized (lock)
         {
    waitingList.add(car);
    System.out.printf("Car %d from Gate " + car.getGate()+" is waiting for an empty spot.\n", car.getCarID());
    lock.wait();
         }
park(waitingList.getFirst());
 waitingList.removeFirst();



                          }
            }
}
