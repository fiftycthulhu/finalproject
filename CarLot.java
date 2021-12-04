package carlot;
import java.io.*;
import java.util.*;

public class CarLot extends ArrayList<Car>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	File file = new File("c:\\cars.csv");
    
	public ArrayList<Car> getInventory() {
		return this;
	}

	public void setInventory(ArrayList<Car> inventory) {
		this.addAll(inventory);
	}
	
	public void addCar(String ID, int mileage, int MPG, double cost, double salesprice) {
		Car c = new Car(ID, mileage, MPG, cost, salesprice);
	    this.add(c);
	}
	
	public void sellCar(String identifier, double priceSold) throws Exception{
		Car c = null; boolean Sold=false;
	    ListIterator<Car> it = this.listIterator();
	    while(it.hasNext()) {
	      c = (Car)it.next();
	      if(!c.isSold() & identifier.equalsIgnoreCase(c.getID())) {
	        c.sellCar(priceSold);
	        Sold = true;
	           }
	       }
	       if(!Sold) {
	           throw new Exception("Car can't be sold.");
	       }
	}
	
	 public Car findCarByIdentifier(String identifier) {
	       Car c = null;
	       ListIterator<Car> it = this.listIterator();
	       while(it.hasNext()) {
	           c = (Car)it.next();
	           if(identifier.equalsIgnoreCase(c.getID())) {
	               break;
	           }
	       }
	       return c;
	   }
	   public ArrayList<Car> getCarsInOrderOfEntry() {
	       ArrayList<Car> inventoryCopy = this;
	       return inventoryCopy;
	   }
	   public ArrayList<Car> getCarsSortedByMPG() {
	       ArrayList<Car> inventoryCopy = this;
	      inventoryCopy.sort(Comparator.comparingInt(Car::getMPG));
	       return inventoryCopy;
	   }
	   public Car getCarWithBestMPG() throws Exception{
	       Car bestMPGCar = this.get(0); Car c = null;
	       ListIterator<Car> it = this.listIterator();
	       while(it.hasNext()) {
	           c = (Car)it.next();
	           if(bestMPGCar!=null && c.compareMPG(bestMPGCar)>0) {
	               bestMPGCar=c;
	           }
	       }
	       return bestMPGCar;
	   }
	   public Car getCarWithHighestMileage() throws Exception{
	       Car highestMileageCar = this.get(0); Car c = null;
	       ListIterator<Car> it = this.listIterator();
	       while(it.hasNext()) {
	           c = (Car)it.next();
	           if(highestMileageCar!=null && c.compareMileage(highestMileageCar)>0) {
	               highestMileageCar=c;
	           }
	       }
	       return highestMileageCar;
	   }
	   public double getAverageMPG() throws Exception{
	       double averageMPG=0; double totalMPG=0; Car c=null;
	       ListIterator<Car> it = this.listIterator();
	       while(it.hasNext()) {
	           c = (Car)it.next();
	           totalMPG+=c.getMPG();
	       }
	       averageMPG=totalMPG/(this.size());
	       return averageMPG;
	   }
	   public double getTotalProfit() throws Exception {
	       double totalProfit = 0; Car c=null;
	       ListIterator<Car> it = this.listIterator();
	       while(it.hasNext()) {
	           c = (Car)it.next();
	           if(c.isSold()) {
	               totalProfit+=c.getProfit();
	           }
	       }
	       return totalProfit;
	   }
	        
			   


	public void loadFromDisk() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = "";
			ArrayList<Car> Copy = new ArrayList<Car>();
	        while ((line = br.readLine()) != null) {
	        	String array[] = line.split(",", 0);
	        	String ID = array[0];
	        	int mileage = Integer.parseInt(array[1]);
	        	int MPG = Integer.parseInt(array[2]);
	        	Double cost = Double.parseDouble(array[3]);
	        	Double salesprice = Double.parseDouble(array[4]);
	        	Boolean sold = Boolean.parseBoolean(array[5]);
	        	Double pricesold = Double.parseDouble(array[6]);
	        	Double profit = Double.parseDouble(array[7]);
	    		Car c = new Car(ID, mileage, MPG, cost, salesprice);
	    		c.setSold(sold);
	    		c.setPriceSold(pricesold);
	    		c.setProfit(profit);
	    	    Copy.add(c);
	        }
	        this.addAll(Copy);
		}
		}

	public void saveToDisk() throws IOException {

		   FileWriter fw = new FileWriter(file);
	        for(int i=0;i<this.size();)
	        {
	        	 Car c = this.get(i);
	        	 fw.append(c.getID() + ",");
	        	 fw.append(c.getMileage() + ",");
	        	 fw.append(c.getMPG() + ",");
	        	 fw.append(c.getCost() + ",");
	        	 fw.append(c.getSalesPrice() + ",");
	        	 fw.append(c.isSold() + ",");
	        	 fw.append(c.getPriceSold() + ",");
	        	 fw.append(c.getProfit() + ",");
	        	 fw.append("\n");
	        	 i++;
	        }
	        fw.close();
	}

	}

