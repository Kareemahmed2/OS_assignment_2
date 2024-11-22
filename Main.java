
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File inputFile = new File("car_schedule.txt");
        Scanner FileReader = new Scanner(inputFile);
        int carNumber=0;
        while (FileReader.hasNextLine()) {
            String line = FileReader.nextLine();
            String[] tokens = line.split(" ");
            int gateNumber= Integer.parseInt(tokens[1].replace(",", ""));
            int carID = Integer.parseInt(tokens[3].replace(",", ""));
            int arrivalTime = Integer.parseInt(tokens[5].replace(",", ""));
            int parkingDuration = Integer.parseInt(tokens[7].replace(",", ""));
            Gate gate=new Gate(gateNumber);
            Car car = new Car(carID, arrivalTime, parkingDuration, gate);
           gate.addCarToList(car);
           carNumber++;
        }
        ParkingLot lot = new ParkingLot(carNumber);
    }
}
