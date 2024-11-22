public class Car extends Thread {
    private final int carID;
    private final int arrivalTime;
    private final int parkingDuration;
    private final Gate gate;

    public Car(int carID, int arrivalTime, int parkingDuration, Gate gate) {
        this.carID = carID;
        this.arrivalTime = arrivalTime;
        this.parkingDuration = parkingDuration;
        this.gate = gate;

    }

    @Override
    public void run() {
        try {
            
            Thread.sleep(arrivalTime * 1000);
            System.out.printf("Car %d from Gate %d arrived at time %d\n", carID, gate.getGateNumber(), arrivalTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCarID() {
        return carID;
    }

    public int getArrival_time() {
        return arrivalTime;
    }

    public int getParking_duration() {
        return parkingDuration;
    }

    public Gate getGate() {
        return gate;
    }

    @Override
    public String toString() {
        return String.format("Car %d from Gate %d (Arrival Time: %d, Parking Duration: %d)", 
                             carID, gate.getGateNumber(), arrivalTime, parkingDuration);
    }
}
