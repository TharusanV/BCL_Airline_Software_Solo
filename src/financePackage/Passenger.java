package financePackage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Passenger{

	/*IF THERE IS AN ERROR PLEASE READ TO FIX - For some reason whenever I export then import this project errors appear so I think the JRE library is not imported correctly
	 * so to fix this go to Project->Properties->Java Build Path->Library->Delete the JRE system library under ModulePath->Add library->Select JRE System Library-> 
	 * Go to execution environment->From the drop down menu you select either the one at the bottom or 1.7 and it should work then*/
	
	private String firstName;
	private String surname;
	private String dateOfBirth;
	private int ticketNumber;
	private int telephone;
	private int numOfBags;
	private int telephoneNumber;
	private String seatDeparture;
	private String seatReturn;
	private Flights depFlight;
	private Flights retFlight;
	
	private Finance passenger_finance; //TV - Finance Component
	Random randomNumberGenerator = new Random();
	
	/*to create the one to one relationship between passenger and finance I created a finance object called  passenger_finance 
	 * which needs to be called using a getter to obtain a passenger's finance attributes/methods*/
	public Passenger(String firstName,String surname,String dateOfBirth, int ticketNumber, String seatDeparture, String seatReturn, Flights depFlight, Flights retFlight) {
		 passenger_finance = new Finance(this);	//TV - Finance Component
	     this.firstName = firstName;
	     this.surname =	surname;
	     this.dateOfBirth = dateOfBirth;
	     this.numOfBags = randomNumberGenerator.nextInt(10); //Random to match the CS1810 brief (Solo)
	     this.ticketNumber = ticketNumber;
	     this.seatDeparture = seatDeparture;
	     this.seatReturn = seatReturn;
	     this.depFlight = depFlight;
	     this.retFlight = retFlight;
	}
	
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public int getNumOfBags() {
		return this.numOfBags;
	}

	public int getTicketNumber() {
		return this.ticketNumber;
	}
	
	public String getSeatDep() {
		return this.seatDeparture;
	}
	
	public String getSeatRet() {
		return this.seatReturn;
	}
	
	public Flights getDepFlight() {
		return this.depFlight;
	}
	
	public Flights getRetFlight() {
		return this.retFlight;
	}

	public Finance getPassenger_finance() {   //TV - Finance Component - Allows the Finance object to refer to the passenger (One-to-One Relationship)
		return passenger_finance;
	}
		
}
