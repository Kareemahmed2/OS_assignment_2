public class Car implements Runnable{
    private int carID;
    private int arrival_time;
    private int Parking_duration;
    private Gate gate;
    @Override
    public void run() {

    }
    
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getParking_duration() {
        return Parking_duration;
    }

    public void setParking_duration(int parking_duration) {
        Parking_duration = parking_duration;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
