public class Car implements Runnable{
    private int carID;
    private int arrival_time;
    private int Parking_duration;
    private Gate gate;
    @Override
    public void run() {
try {
            Thread.sleep(arrival_time * 1000);
            System.out.println("Car " + carID + " from Gate " + gate.getGateNumber() + " arrived at time " + arrival_time);
    
            if (parkingLot.tryToPark(this)) {
                System.out.println("Car " + carID + " from Gate " + gate.getGateNumber() + " parked. (Parking Status: " + parkingLot.getOccupiedSpots() + " spots occupied)");
                Thread.sleep(parking_duration * 1000); 
                parkingLot.leaveParking(this);
                System.out.println("Car " + carID + " from Gate " + gate.getGateNumber() + " left after " + parking_duration + " units of time. (Parking Status: " + parkingLot.getOccupiedSpots() + " spots occupied)");
            } else {
                System.out.println("Car " + carID + " from Gate " + gate.getGateNumber() + " waiting for a spot.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
