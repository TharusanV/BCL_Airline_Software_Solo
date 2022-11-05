package financePackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestFinanceComponent {
	
	//Test Data from CS1810 Brief
	Flights depTokyoToSydney = new Flights("08/03/2022", "06:20", "11:57", "05:37", 7021.04, 179, "HND","Tokyo", "SYD", "Sydney", "TS4977", "Easyplane");
	Flights retSydneyToTokyo = new Flights("27/03/2022", "18:23", "03:44", "09:21", 11687.85, 10, "SYD", "Sydney", "HND", "Tokyo", "ST4138", "Eastair");
	Passenger passenger1 = new Passenger("Aaron", "Samuels", "01/12/99", 83746578, "1A", "1A",depTokyoToSydney,retSydneyToTokyo);
	
	@Test
	void testGetterAndSetterForTotalBagCost() {
		/*I set the number of Bags to 5 to see if the setTotalBagCost and getTotalBagCost methods work correctly as the getter should return 100 as one bag is free but any bag 
		 * over is (numOfBags-1)*25 (also because in CS1810 implementing my component solo involved having the number of bags be random which I can't test if the calculation 
		 * is correct or not so I just manually set the number of bags)*/
		passenger1.getPassenger_finance().setTotalBagCost(5);
		int validBagCost = passenger1.getPassenger_finance().getTotalBagCost();
		assertEquals(100,validBagCost);
	}
	
	@Test
	void testGetterAndSetterForTicketCost() {
		passenger1.getPassenger_finance().setTicketCost(passenger1.getDepFlight().getDistanceTravelled(), passenger1.getDepFlight().getFlightDuration(), passenger1.getSeatDep(), 
														passenger1.getRetFlight().getDistanceTravelled(), passenger1.getRetFlight().getFlightDuration(), passenger1.getSeatRet());
		//Calculated it out before the correct answer should be 28063.34
		double validTicketCost = passenger1.getPassenger_finance().getTotalTicketCost();
		assertEquals(28063.34,validTicketCost);
	}
	
	@Test
	void testGetterAndSetterForCompensation() {
		passenger1.getPassenger_finance().setCompensationCost(passenger1.getDepFlight().getDelay(),passenger1.getRetFlight().getDelay());
		//Answer should be 200 as the compensation for the departure is 200 (179>120 and 179<=180) and the compensation for return is 0 (10<60)
		int validCompensation = passenger1.getPassenger_finance().getCompensation();
		assertEquals(200,validCompensation);
	}
	
	@Test
	void testGetterAndSetterForTotalRestaurantCost() {
		passenger1.getPassenger_finance().setRestaurantCost(50.564); //Gave it a value as it would be random otherwise which I can't test
		double validRestaurantCost = passenger1.getPassenger_finance().getTotalRestaurantCost(); 
		assertEquals(50.56,validRestaurantCost);
	}
	
	@Test
	void testGetterAndSetterForTotalShopCost() {
		passenger1.getPassenger_finance().setShopCost(142.5231521); //Gave it a value as it would be random otherwise which I can't test
		double validShopCost = passenger1.getPassenger_finance().getTotalShopCost();
		assertEquals(142.52,validShopCost);
	}
	
	@Test
	void testGetterAndSetterForTotalOverallCost() {
		passenger1.getPassenger_finance().setTotalOverallCost(125, 24596.95, 24.99, 15, 100); //I'm just going to set the values as it would be easier for me to calculate the valid answer
		double validTotalOverallCost = passenger1.getPassenger_finance().getTotalOverallCost();
		assertEquals(24661.94,validTotalOverallCost);
	}
	
}
