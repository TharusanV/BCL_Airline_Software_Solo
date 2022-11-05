package financePackage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Flights {
	
	/*IF THERE IS AN ERROR PLEASE READ TO FIX - For some reason whenever I export then import this project errors appear so I think the JRE library is not imported correctly
	 * so to fix this go to Project->Properties->Java Build Path->Library->Delete the JRE system library under ModulePath->Add library->Select JRE System Library-> 
	 * Go to execution environment->From the drop down menu you select either the one at the bottom or 1.7 and it should work then*/
	
	private String dateOfFlight;
	private String departureTime;
	private String arrivalTime;
	private String flightDuration;
	private double distanceTravelled;
	private int delay;
	private String departureAirport;
	private String departureCity;
	private String arrivalAirport;
	private String arrivalCity;
	private String flightNumber;
	private String airline;
	
	static ArrayList<Object> departureFlightsArrayList = new ArrayList<Object>(); //Static so it can be used in other classes
	static ArrayList<Object> arrivalFlightsArrayList = new ArrayList<Object>(); //Static so it can be used in other classes
	
	
	public Flights(String dateOfFlight, String departureTime,String arrivalTime, String flightDuration, double distanceTravelled, int delay, String departureAirport, String departureCity, 
			String arrivalAirport, String arrivalCity, String flightNumber, String airline) {
		
		this.dateOfFlight = dateOfFlight;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightDuration = flightDuration;
		this.distanceTravelled = distanceTravelled;
		this.delay = delay;
		this.departureAirport = departureAirport;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.arrivalAirport = arrivalAirport;
		this.flightNumber = flightNumber;
		this.airline = airline;			
	}
	
	//Only these getters are needed as I don't need the rest for my component
	public double getDistanceTravelled() {
		return this.distanceTravelled;
	}
	
	public int getDelay() {
		return this.delay;
	}

	public String getFlightDuration() {
		return this.flightDuration;
	}
	
	
}
