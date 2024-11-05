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
public class Gate implements Runnable{
    ArrayList<Car> cars;
    int gateNumber;

    public Gate(int i) {}
public void addCarToList(Car c)
{
    cars.add(c);
}

    public ArrayList<Car> getCars() {
        return cars;
    }

    @Override
    public void run() {

    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }
}
