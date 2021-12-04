package carlot;
import java.util.*;
public class CarLotMain {
//[0] Exit
//	[1] Add a car to inventory
//	[2] Sell a car from inventory
//	[3] List inventory by order of acquisition
//	[4] List Inventory From Best MPG to Worst MPG
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		CarLot carlot1 = new CarLot();
		System.out.println("[0] Exit\r\n"
				+ "[1] Add a car to inventory\r\n"
				+ "[2] Sell a car from inventory\r\n"
				+ "[3] List inventory by order of acquisition\r\n"
				+ "[4] List Inventory From Best MPG to Worst MPG\r\n"
				+ "[5] Display car with best MPG\r\n"
				+ "[6] Display car with the highest mileage\r\n"
				+ "[7] Display overall MPG for the entire inventory\r\n"
				+ "[8] Display profit for all sold cars\r\n"
				+ "[9] Save to file\r\n"
				+ "[10] Load file\r\n"
				+ "Enter a number from 0 to 10:");
		int inpu = input.nextInt();
		while (inpu != 0) {
			if (inpu == 1) {
				System.out.println("Car identifier: ");
				String identifier = input.next();
				System.out.println("Car mileage: ");
				int mileage = input.nextInt();
				System.out.println("Car mpg: ");
				int mpg = input.nextInt();
				System.out.println("Car cost (not sales price): ");
				double cost = input.nextDouble();
				System.out.println("Car sales price: ");
				double salesPrice = input.nextDouble();
				carlot1.addCar(identifier, mileage, mpg, cost, salesPrice);
				inpu = 9;
			}
			else if (inpu == 2) {
				System.out.println("Car identifier: ");
				String identifier = input.next();

				System.out.println("Car price sold: ");
				double soldprice = input.nextDouble();
				carlot1.sellCar(identifier, soldprice);
				inpu = 9;	
			}
			else if (inpu == 3) {
				System.out.println("car lot's cars sorted in order of entry: " + carlot1.getCarsInOrderOfEntry());
				inpu = 9;	
			}
			else if (inpu == 4) {
				System.out.println("car lot's cars sorted by MPG highest to lowest: " + carlot1.getCarsSortedByMPG());
				inpu = 9;
			}
			else if (inpu == 5) {
				System.out.println("car lot's car with the best MPG: " + carlot1.getCarWithBestMPG());

				inpu = 9;
			}
			else if (inpu == 6) {
				System.out.println("car lot's car with the highest mileage: " + carlot1.getCarWithHighestMileage());
				
				inpu = 9;
			}
			else if (inpu == 7) {
				System.out.println("car lot's average MPG: " + carlot1.getAverageMPG());
				inpu = 9;
			}
			else if (inpu == 8) {
				System.out.println("car lot's total profit: " + carlot1.getTotalProfit());
				inpu = 9;
			}
			else if (inpu == 9) {
				carlot1.saveToDisk();
				System.out.println("Saved");
				inpu = 11;
			}
			else if (inpu == 10) {
				carlot1.loadFromDisk();
				System.out.println("Loaded");
				inpu = 11;
			}
			else{
				System.out.println("Enter a number from 0 to 8:");
				 inpu = input.nextInt();
			}

		}
		input.close();
	}

}
