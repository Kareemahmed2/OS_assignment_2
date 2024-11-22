import java.util.*;

public class Semaphore {
    protected int value;
    protected List<Car> waitingList= new ArrayList<Car>();
    protected Semaphore(int value) {
        this.value = value;
    }
    public synchronized void P() {//the wait function
        value--;                  // it tells the outside cars to wait as there is no available parking spots
        if(value <=0) {
            try {
               // waitingList.add(new Car());
                System.out.printf("Car %d from Gate %d is waiting for an empty spot.\n",new Car().getCarID(), new Car().getGate().getGateNumber());
                wait();
            } catch (InterruptedException e) {}


        }

    }
    public synchronized void V() { // the notify function
        value++;
        if(value <= 0) {

            notify();
           /* if (!waitingList.isEmpty())
            {
               // waitingList.removeFirst();
            }*/
        }
    }
    public synchronized boolean tryAcquire() {
        if (value > 0) {
            value--; // Acquire the permit
            return true;
        }
        return false; // No permit available
    }
}
