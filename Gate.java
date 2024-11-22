import java.util.ArrayList;

enum gates{
    ONE(1), TWO(2), THREE(3);
    private final int value;
    gates(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
public class Gate implements Runnable {
    private ArrayList<Car> cars;
    private int gateNumber;

    public Gate(int gateNumber) {
        this.gateNumber = gateNumber;
        this.cars = new ArrayList<>();
    }

    public void addCarToList(Car c) {
        cars.add(c);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    @Override
    public void run() {
        for (Car car : cars) {
            new Thread(car).start();
        }
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }
}
