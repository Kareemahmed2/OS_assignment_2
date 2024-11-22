package OS_assignment_2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File inputFile = new File("input.txt");
        Scanner FileReader = new Scanner(inputFile);
        ParkingLot lot = new ParkingLot();
        while (FileReader.hasNextLine()) {
            String line = FileReader.nextLine();
            String[] tokens = line.split(" ");
            int gateNumber = Integer.parseInt(tokens[1].replace(",", ""));
            int carID = Integer.parseInt(tokens[3].replace(",", ""));
            int arrivalTime = Integer.parseInt(tokens[5].replace(",", ""));
            int parkingDuration = Integer.parseInt(tokens[7].replace(",", ""));
            Car car = new Car(carID, arrivalTime, parkingDuration, gateNumber);
        }
    }
}
