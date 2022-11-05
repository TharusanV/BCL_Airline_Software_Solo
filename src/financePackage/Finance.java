package financePackage;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Finance {
	
		/*IF THERE IS AN ERROR PLEASE READ TO FIX - For some reason whenever I export then import this project errors appear so I think the JRE library is not imported correctly
		 * so to fix this go to Project->Properties->Java Build Path->Library->Delete the JRE system library under ModulePath->Add library->Select JRE System Library-> 
		 * Go to execution environment->From the drop down menu you select either the one at the bottom or 1.7 and it should work then*/
		
		String[] depBoeingFirstClassSeatsArray = {"1A","2A","3A","4A","5A","1B","2B","3B","4B","5B"};
		String[] depBoeingBusinessSeatsArray = {"6A","7A","8A","9A","10A","6B","7B","8B","9B","10B",
												"6C","7C","8C","9C","10C","6D","7D","8D","9D","10D"};
		String[] depBoeingEconomySeatsArray = {"11A","11B","11C","11D","11E","11F",
											   "12A","12B","12C","12D","12E","12F",
											   "13A","13B","13C","13D","13E","13F", 
											   "14A","14B","14C","14D","14E","14F",
											   "15A","15B","15C","15D","15E","15F",
											   "16A","16B","16C","16D","16E","16F", 
											   "17A","17B","17C","17D","17E","17F",
											   "18A","18B","18C","18D","18E","18F",
											   "19A","19B","19C","19D","19E","19F"};
		
		String[] retBoeingFirstClassSeatsArray = {"1A","2A","3A","4A","5A","1B","2B","3B","4B","5B"};
		String[] retBoeingBusinessSeatsArray = {"6A","7A","8A","9A","10A","6B","7B","8B","9B","10B",
												"6C","7C","8C","9C","10C","6D","7D","8D","9D","10D"};
		String[] retBoeingEconomySeatsArray = {"11A","11B","11C","11D","11E","11F",
											   "12A","12B","12C","12D","12E","12F",
											   "13A","13B","13C","13D","13E","13F", 
											   "14A","14B","14C","14D","14E","14F",
											   "15A","15B","15C","15D","15E","15F",
											   "16A","16B","16C","16D","16E","16F", 
											   "17A","17B","17C","17D","17E","17F",
											   "18A","18B","18C","18D","18E","18F",
											   "19A","19B","19C","19D","19E","19F"};
	
		String[] depAirbusBusinessSeatsArray = {"1A","2A","3A","4A","5A","1B","2B","3B","4B","5B"};
		String[] depAirbusEconomySeatsArray = {"6A","7A","8A","9A","10A","6B","7B","8B","9B","10B",
											   "6C","7C","8C","9C","10C","6D","7D","8D","9D","10D",
											   "11A","11B","11C","11D","11E","11F","12A","12B","12C",
											   "12D","12E","12F","13A","13B","13C","13D","13E","13F", 
											   "14A","14B","14C","14D","14E","14F"};
		
		String[] retAirbusBusinessSeatsArray = {"1A","2A","3A","4A","5A","1B","2B","3B","4B","5B"};
		String[] retAirbusEconomySeatsArray = {"6A","7A","8A","9A","10A","6B","7B","8B","9B","10B",
											   "6C","7C","8C","9C","10C","6D","7D","8D","9D","10D",
											   "11A","11B","11C","11D","11E","11F","12A","12B","12C",
											   "12D","12E","12F","13A","13B","13C","13D","13E","13F", 
											   "14A","14B","14C","14D","14E","14F"};
	
		/*Attributes for the Passenger's finance object (Private so they can't be edited/accessed by
		anything apart from my getters and setters - Encapsulation) */
		private int totalBagCost;
		private double totalTicketCost;
		private double totalRestaurantCost;
		private double totalProductCost;
		private int compensation;
		private double totalOverallCost;
		private Passenger personData; 

		/*Used only to randomise the data as stated in the CS1810 brief solo implementation 
		(Would be removed in the group implementation CS1803.3)*/
		Random randomNumberGenerator = new Random();  
		
		/*Finance Constructor method (OOP) - 
		Passenger object is passed into the finance constructor so attributes and methods of the right passenger can be accessed from the finance object.*/
		public Finance(Passenger personData) {
			this.personData = personData;
			this.totalBagCost = 0;
			this.totalTicketCost = 0;
			this.totalRestaurantCost = randomNumberGenerator.nextInt(50); //Random as stated in the brief (Solo)
			this.totalProductCost = randomNumberGenerator.nextInt(50); //Random as stated in the brief (Solo)
			this.compensation = 0;
			this.totalOverallCost = 0;
		}
		
		//Setter Method 1 - Total Bag Cost
		public void setTotalBagCost(int numOfBags) {
			if (numOfBags > 1) {
				int totalBagCost = (numOfBags - 1) * 25;
				this.totalBagCost = totalBagCost;
			}
			else {
				int totalBagCost = 0;
				this.totalBagCost = totalBagCost;
			}
		}
		
		
		/*Setter Method 2 - Ticket Cost -  Splits the hour and minutes of the flight duration into a array then stores the first item of the array into an integer variable
		 and then fills everything in the array with null to empty out the array so that the method can be used again with this being done for the departure and return
		 flight duration times. Through this the method is able to tell using nested if statements what type of aeroplane the departure and arrival flights are with >2 being
		 Boeing and <=2 being Airbus so that I can determine is seat 1A is a First class seat (Boeing) or a Business seat(Airbus). The calculation then runs as normal also
		 apologies for the nested if statements and way the actual calculation is written as due to time constraints I wasn't able to fix it before the deadline*/
		public void setTicketCost(double depFlightDistance, String depFlightDuration, String depSeat, double retFlightDistance, String retFlightDuration, String retSeat) {
			String[] depTime = depFlightDuration.split(":");
			String[] retTime = retFlightDuration.split(":");
			int depDurationHour = Integer.parseInt (depTime[0]);
			int retDurationHour = Integer.parseInt (retTime[0]);
			Arrays.fill(depTime, null);
			Arrays.fill(retTime, null);
			if(depDurationHour > 02) {
				if (Arrays.asList(depBoeingFirstClassSeatsArray).contains(depSeat)) {
					if(retDurationHour > 02) {
						if (Arrays.asList(retBoeingFirstClassSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1.5)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1.5)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0; 
						}
					}
					else {
						if(Arrays.asList(retAirbusBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retAirbusEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1.5)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0; 
						}
					}
				}
				else if (Arrays.asList(depBoeingBusinessSeatsArray).contains(depSeat)) {
					if(retDurationHour > 02) {
						if (Arrays.asList(retBoeingFirstClassSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 1.5)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0; 
						}
					}
					else {
						if(Arrays.asList(retAirbusBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retAirbusEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0; 
						}
					}
				}
				else if (Arrays.asList(depBoeingEconomySeatsArray).contains(depSeat)) {
					if(retDurationHour > 02) {
						if (Arrays.asList(retBoeingFirstClassSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1.5)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0; 
						}
					}
					else {
						if(Arrays.asList(retAirbusBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retAirbusEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0; 
						}
					}
				}
			}
			else {
				if (Arrays.asList(depAirbusBusinessSeatsArray).contains(depSeat)) {
					if(retDurationHour > 02) {
						if (Arrays.asList(retBoeingFirstClassSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 1.5)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0; 
						}
					}
					else {
						if(Arrays.asList(retAirbusBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retAirbusEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 1)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0;
						}
					}
				}
				if (Arrays.asList(depAirbusEconomySeatsArray).contains(depSeat)) {
					if(retDurationHour > 02) {
						if (Arrays.asList(retBoeingFirstClassSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1.5)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retBoeingEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0;
						}
					}
					else {
						if(Arrays.asList(retAirbusBusinessSeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 1)*100)/100.0))*100))/100.0;
						}
						else if(Arrays.asList(retAirbusEconomySeatsArray).contains(retSeat)) {
							this.totalTicketCost = (Math.round(((Math.round((depFlightDistance * 0.5)*100)/100.0)	+	(Math.round((retFlightDistance * 0.5)*100)/100.0))*100))/100.0;
						}
					}
				}
			}
		}

		
		//Setter Method 3 - Compensation
		public void setCompensationCost(int depDelay, int retDelay) {
			if (depDelay > 180) {
				if(retDelay > 180) {
					this.compensation = 600;
				}
				if(retDelay > 120 && retDelay <= 180) {
					this.compensation = 500;
				}
				if(retDelay > 60 && retDelay <= 120) {
					this.compensation = 400;
				}
				else {
					this.compensation = 300;
				}
			}
			else if (depDelay > 120 && depDelay<=180) {
				if(retDelay > 180) {
					this.compensation = 500;
				}
				if(retDelay > 120 && retDelay <= 180) {
					this.compensation = 400;
				}
				if(retDelay > 60 && retDelay <= 120) {
					this.compensation = 300;
				}
				else {
					this.compensation = 200;
				}	
			}
			else if (depDelay > 60 && depDelay<=120) {
				if(retDelay > 180) {
					this.compensation = 400;
				}
				if(retDelay > 120 && retDelay <= 180) {
					this.compensation = 300;
				}
				if(retDelay > 60 && retDelay <= 120) {
					this.compensation = 200;
				}
				else {
					this.compensation = 100;
				}			
			}
			else if (depDelay <= 60) {
				if(retDelay > 180) {
					this.compensation = 300;
				}
				if(retDelay > 120 && retDelay <= 180) {
					this.compensation = 200;
				}
				if(retDelay > 60 && retDelay <= 120) {
					this.compensation = 100;
				}
				else {
					this.compensation = 0;
				}			
			}
		}
		
		
		//Setter Method 4 - Restaurant Cost (Would be used in the Restaurant GUI when my group Fully integrate all our parts in CS1803.3)
		public void setRestaurantCost(double totalFoodCost) {
			double formatedFoodCost = Math.round(totalFoodCost*100)/100.0;
			this.totalRestaurantCost = formatedFoodCost;
		}
		
		//Setter Method 5 - Shop Cost (Would be used in the Shop GUI when my group Fully integrate all our parts in CS1803.3)
		public void setShopCost(double totalProductCost) {
			double formatedProductCost = Math.round(totalProductCost*100)/100.0;
			this.totalProductCost = formatedProductCost;
		}
				
		
		//Setter Method 6 - Total Cost
		public void setTotalOverallCost(int totalBagCost, double ticketCost, double restaurantCost, double productCost, int compensation){
			double calculation = (totalBagCost + ticketCost + restaurantCost + productCost) - compensation;
			double totalCost = Math.round(calculation*100)/100.0;
			this.totalOverallCost = totalCost;	
		}
		
		
		
		
		
		
		//Getter Method 1 - Bag Cost
		public int getTotalBagCost() {
			return this.totalBagCost;
		}
		
		//Getter Method 2 - Ticket Cost
		public double getTotalTicketCost() {
			return this.totalTicketCost;
		}
		
		//Getter Method 3 - Compensation
		public int getCompensation() {
			return this.compensation;
		}	
		
		//Getter Method 4 - Restaurant Cost
		public double getTotalRestaurantCost() {
			return this.totalRestaurantCost;
		}	
		
		//Getter Method 5 - Shop Cost
		public double getTotalShopCost() {
			return this.totalProductCost;
		}	
			
		
		//Getter Method 6 - Total Cost
		public double getTotalOverallCost() {
			return this.totalOverallCost;
		}	
		
	
}
