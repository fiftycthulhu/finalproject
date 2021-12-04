package carlot;


public class Car {
	private String ID;
	private int mileage;
	private int MPG;
	private double cost;
	private double salesPrice;
	private boolean Sold;
	private double priceSold;
	private double profit;
	
	public Car() {
		this.ID = null;
		this.mileage = 0;
		this.MPG = 0;
		this.cost = 0;
		this.salesPrice = 0;
		this.Sold = false;
		this.priceSold = 0;
		this.profit = 0;
	}
	
	public Car(String ID, int mileage, int MPG, double cost, double salesPrice) {
		this.ID = ID;
		this.mileage = mileage;
		this.MPG = MPG;
		this.cost = cost;
		this.salesPrice = salesPrice;
	}
	
	public java.lang.String toString() {
		String full = "";
		if (Sold){
			full = "\nCar: " + ID + " Mileage: " + mileage + " MPG: " + MPG + " Sold: Yes Cost: $" + String.format("%.2f", cost) +  " Sales price: $" + String.format("%.2f", salesPrice) +" Price Sold: $" + String.format("%.2f", priceSold) + " Profit: $" + String.format("%.2f", profit);	
		}
		else {
			full = "\nCar: " + ID + " Mileage: " + mileage + " MPG: " + MPG + " Sold: No Cost: $" + String.format("%.2f", cost) + " Sales price: $"+ String.format("%.2f", salesPrice);
		}
		return full;
		
	}
	
	
	public void sellCar(double priceSold) {
		Sold = true;
		this.priceSold = priceSold;
		this.profit = priceSold - cost;
		
	}
	
	public int compareMPG(Car otherCar) {
		int compare = 0;
		if (MPG > otherCar.MPG) {
			compare = 1;
		}
		else if (MPG < otherCar.MPG) {
			compare = -1;
		}
		else {
			compare = 0;
		}
		return compare;
	}
	
	public int compareMileage(Car otherCar) {
		int compare1 = 0;
		if (mileage > otherCar.mileage) {
			compare1 = 1;
		}
		else if (mileage < otherCar.mileage) {
			compare1 = -1;
		}
		else {
			compare1 = 0;
		}
		return compare1;

	}
	
	public double compareSalesprice(Car otherCar) {
		int compare2 = 0;
		if (salesPrice > otherCar.salesPrice) {
			compare2 = 1;
		}
		else if (salesPrice < otherCar.salesPrice) {
			compare2 = -1;
		}
		else {
			compare2 = 0;
		}
		return compare2;
	}

	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getMPG() {
		return MPG;
	}

	public void setMPG(int mPG) {
		MPG = mPG;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public boolean isSold() {
		return Sold;
	}

	public void setSold(boolean sold) {
		this.Sold = sold;
	}

	public double getPriceSold() {
		return priceSold;
	}

	public void setPriceSold(double priceSold) {
		this.priceSold = priceSold;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

}
