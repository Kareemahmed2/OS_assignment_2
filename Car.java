public class Car {
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
