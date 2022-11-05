package financePackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import financePackage.Finance_GUI;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Finance_GUI extends JFrame {
	
	/*IF THERE IS AN ERROR PLEASE READ TO FIX - For some reason whenever I export then import this project errors appear so I think the JRE library is not imported correctly
	 * so to fix this go to Project->Properties->Java Build Path->Library->Delete the JRE system library under ModulePath->Add library->Select JRE System Library-> 
	 * Go to execution environment->From the drop down menu you select either the one at the bottom or 1.7 and it should work then*/

	/*Note: I understand that using multiple packages is ideal and just importing them to each class when I need to link one class to another
	 		however as this project focuses on the 'Finance' component I just decided to put everything under one roof*/
	
	private JPanel contentPane;
	private JTable financeTable;
	
	DefaultTableModel model; 
	private JLabel logoLabel;
	private JLabel blackRect1Label;
	private JLabel blueRect1Label;
	private JLabel blueRect2Label;
	private JLabel blueRect3Label;
	private JLabel blackRect2Label;
	private JLabel blackRect3Label;
	private JLabel blackRect4Label;
	private JLabel WelcomeToBCLTextLabel;
	private JLabel blackRect5Label;
	private JLabel blueRect4Label;
	private JLabel blackRect6Label;
	private JLabel financeTitleLabel;
	private JLabel financeSummaryTextLabel;
	private JLabel globeLabel;
	private JLabel languageTextLabel;
	
	/*According the CS1810 brief my Project should have the following as I am implementing it individually: 
	Store the following departure flight “08/03/2022, 06:20, 11:57, 05:37, 7021.04, 179, HND,
	Tokyo, SYD, Sydney, TS4977, Easyplane” and the following return flight “27/03/2022, 18:23,
	03:44, 09:21, 11687.85, 10, SYD, Sydney, HND, Tokyo, ST4138, Eastair” and the following
	passenger names with their corresponding ticket numbers for the return flight (Tokyo to
	Sydney) and seat numbers “Aaron Samuels – 83746578 – 1A”, “Regina George – 27475839 –
	6A” and “Cady Heron – 95738494 – 11A”. Generate a random number for their number of
	bags, cost of products and cost of food items and carry out the functionality as specified
	above under 6. Finances */
	
	//Array list to hold all the passengers which I would iterate through
	ArrayList<Object> passengersArrayList = new ArrayList<Object>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finance_GUI frame = new Finance_GUI();
					frame.setTitle("Brunel City London Airport");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Finance_GUI() {
		setResizable(false);	//The window won't be able to be resized by the user
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800); //Size of the window
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(); 
		scrollPane.setBounds(211, 273, 847, 420);
		contentPane.add(scrollPane);
		
		//Solo Version - Given Flights
		Flights depTokyoToSydney = new Flights("08/03/2022", "06:20", "11:57", "05:37", 7021.04, 179, "HND","Tokyo", "SYD", "Sydney", "TS4977", "Easyplane");
		Flights retSydneyToTokyo = new Flights("27/03/2022", "18:23", "03:44", "09:21", 11687.85, 10, "SYD", "Sydney", "HND", "Tokyo", "ST4138", "Eastair");
		
		//Solo Version - Given Passengers
		passengersArrayList.add(new Passenger("Aaron", "Samuels", "01/12/99", 83746578, "1A", "1A",depTokyoToSydney,retSydneyToTokyo));
		passengersArrayList.add(new Passenger("Regina", "George", "05/04/90", 27475839, "6A", "6A",depTokyoToSydney,retSydneyToTokyo));
		passengersArrayList.add(new Passenger("Cady","Heron", "10/21/75" ,95738494, "11A", "11A",depTokyoToSydney,retSydneyToTokyo));
		
		
		//Images + Resized Images
		Image logo = new ImageIcon(this.getClass().getResource("/BCL_Logo3.png")).getImage();
		Image resizedLogo = logo.getScaledInstance(248, 109, java.awt.Image.SCALE_SMOOTH);
		
		Image blackRectangle = new ImageIcon(this.getClass().getResource("/blackRectangle.png")).getImage();
		Image resizedBlackRectangle = blackRectangle.getScaledInstance(1280, 800, java.awt.Image.SCALE_SMOOTH);
		
		Image blueRectangle = new ImageIcon(this.getClass().getResource("/blueRectangle.png")).getImage();
		Image resizedBlueRectangle = blueRectangle.getScaledInstance(1280, 800, java.awt.Image.SCALE_SMOOTH);

		Image globe = new ImageIcon(this.getClass().getResource("/globe.png")).getImage();
		Image resizedGlobe = globe.getScaledInstance(27, 28, java.awt.Image.SCALE_SMOOTH);
		
		
		//Buttons
		JButton flightsButton = new JButton("Flights");
		flightsButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose(); //Use if you want only one window / Don't if you want to have multiple windows
				Flights_GUI homeFrame = new Flights_GUI(); 
				homeFrame.setVisible(true);
			}
		});
		flightsButton.setBounds(470, 44, 127, 23);
		contentPane.add(flightsButton);
		
		JButton restaurantButton = new JButton("Restaurant");
		restaurantButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose(); //Use if you want only one window / Don't if you want to have multiple windows
				Restaurant_GUI restaurantFrame = new Restaurant_GUI(); 
				restaurantFrame.setVisible(true);
			}
		});
		restaurantButton.setBounds(657, 44, 112, 23);
		contentPane.add(restaurantButton);
		
		JButton shopButton = new JButton("Shop");
		shopButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose(); //Use if you want only one window / Don't if you want to have multiple windows
				Shop_GUI shopFrame = new Shop_GUI(); 
				shopFrame.setVisible(true);
			}
		});
		shopButton.setBounds(821, 44, 112, 23);
		contentPane.add(shopButton);
		
		
		//Logo and Globe
		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(resizedLogo));
		logoLabel.setBounds(153, 0, 257, 96);
		contentPane.add(logoLabel);
		
		globeLabel = new JLabel("");
		globeLabel.setIcon(new ImageIcon(resizedGlobe));
		globeLabel.setBounds(1031, 11, 34, 37);
		contentPane.add(globeLabel);
		
		
		//Text
		WelcomeToBCLTextLabel = new JLabel("Welcome to Brunel City London Airport Finance");
		WelcomeToBCLTextLabel.setForeground(Color.WHITE);
		WelcomeToBCLTextLabel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		WelcomeToBCLTextLabel.setBounds(447, 105, 348, 20);
		contentPane.add(WelcomeToBCLTextLabel);
		
		financeSummaryTextLabel = new JLabel("Welcome to the Finance section of the Brunel City London Airport software where you will be able to find all your flight financial data.");
		financeSummaryTextLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		financeSummaryTextLabel.setBounds(211, 206, 847, 37);
		contentPane.add(financeSummaryTextLabel);
		
		languageTextLabel = new JLabel("United Kingdom - English");
		languageTextLabel.setForeground(new Color(0, 191, 255));
		languageTextLabel.setBounds(1075, 21, 141, 14);
		contentPane.add(languageTextLabel);
		
		//Rectangles
		blackRect1Label = new JLabel("");
		blackRect1Label.setIcon(new ImageIcon(resizedBlackRectangle));
		blackRect1Label.setBounds(0, 0, 1274, 96);
		contentPane.add(blackRect1Label);
		
		blueRect1Label = new JLabel("");
		blueRect1Label.setIcon(new ImageIcon(resizedBlueRectangle));
		blueRect1Label.setBounds(0, 94, 1274, 10);
		contentPane.add(blueRect1Label);
		
		blueRect2Label = new JLabel("");
		blueRect2Label.setIcon(new ImageIcon(resizedBlueRectangle));
		blueRect2Label.setBounds(0, 126, 1274, 10);
		contentPane.add(blueRect2Label);
		
		blueRect3Label = new JLabel("");
		blueRect3Label.setIcon(new ImageIcon(resizedBlueRectangle));
		blueRect3Label.setBounds(136, 126, 10, 645);
		contentPane.add(blueRect3Label);
		
		blackRect2Label = new JLabel("");
		blackRect2Label.setIcon(new ImageIcon(resizedBlackRectangle));
		blackRect2Label.setBounds(126, 126, 10, 645);
		contentPane.add(blackRect2Label);
		
		blackRect3Label = new JLabel("");
		blackRect3Label.setIcon(new ImageIcon(resizedBlackRectangle));
		blackRect3Label.setBounds(146, 126, 10, 645);
		contentPane.add(blackRect3Label);
		
		blackRect4Label = new JLabel("");
		blackRect4Label.setIcon(new ImageIcon(resizedBlackRectangle));
		blackRect4Label.setBounds(0, 101, 1274, 26);
		contentPane.add(blackRect4Label);
		
		blackRect5Label = new JLabel("");
		blackRect5Label.setIcon(new ImageIcon(resizedBlackRectangle));
		blackRect5Label.setBounds(1125, 126, 10, 645);
		contentPane.add(blackRect5Label);
		
		blueRect4Label = new JLabel("");
		blueRect4Label.setIcon(new ImageIcon(resizedBlueRectangle));
		blueRect4Label.setBounds(1135, 126, 10, 645);
		contentPane.add(blueRect4Label);
		
		blackRect6Label = new JLabel("");
		blackRect6Label.setIcon(new ImageIcon(resizedBlackRectangle));
		blackRect6Label.setBounds(1145, 126, 10, 645);
		contentPane.add(blackRect6Label);
		
		financeTitleLabel = new JLabel("Finance");
		financeTitleLabel.setForeground(new Color(0, 191, 255));
		financeTitleLabel.setFont(new Font("Adobe Devanagari", Font.BOLD, 40));
		financeTitleLabel.setBounds(211, 171, 157, 55);
		contentPane.add(financeTitleLabel);
		
		
		//For the table 
		financeTable = new JTable();	
		financeTable.setEnabled(false);	//Set to false as I don't need the table to respond to user inputs
		model=new DefaultTableModel(); 
		Object[] column = {"First Name","Surname","Date Of Birth","Ticket Number","Bag Cost","Ticket Cost","Food Cost","Product Cost", "Compensation","Total Cost"}; // Column Names
		Object[] row = new Object[10]; 
		model.setColumnIdentifiers(column);
		financeTable.setModel(model); 
		financeTable.getTableHeader().setReorderingAllowed(false); //Stops the table from reordering
		financeTable.getTableHeader().setResizingAllowed(false); //Stops the table from changing size
		scrollPane.setViewportView(financeTable);	//The use of a scrollPane on the JTable will allow the JTable hold an unlimited number of passengers due to the addition of a scroll bar on the JTable 
		
		for(int counter = 0; counter < passengersArrayList.size(); counter++) {
			
			((Passenger) passengersArrayList.get(counter)).getPassenger_finance().setTotalBagCost(((Passenger) passengersArrayList.get(counter)).getNumOfBags());
			
			((Passenger) passengersArrayList.get(counter)).getPassenger_finance().setTicketCost(
					((Passenger) passengersArrayList.get(counter)).getDepFlight().getDistanceTravelled(),
					((Passenger) passengersArrayList.get(counter)).getDepFlight().getFlightDuration(),
					((Passenger) passengersArrayList.get(counter)).getSeatDep(),
					((Passenger) passengersArrayList.get(counter)).getRetFlight().getDistanceTravelled(),
					((Passenger) passengersArrayList.get(counter)).getRetFlight().getFlightDuration(),
					((Passenger) passengersArrayList.get(counter)).getSeatRet());
			
			((Passenger) passengersArrayList.get(counter)).getPassenger_finance().setCompensationCost(((Passenger) passengersArrayList.get(counter)).getDepFlight().getDelay() 
																									,((Passenger) passengersArrayList.get(counter)).getRetFlight().getDelay());
			
			int getTotalBagCost = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalBagCost();
			double getTotalTicketCost = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalTicketCost();
			double getTotalRestaurantCost = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalRestaurantCost();
			double getTotalShopCost = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalShopCost();
			int getTotalCompensation = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getCompensation();
			((Passenger) passengersArrayList.get(counter)).getPassenger_finance().setTotalOverallCost(getTotalBagCost,getTotalTicketCost,getTotalRestaurantCost,getTotalShopCost,getTotalCompensation);
			
			//Sets the rows of the table with the passenger's corresponding attributes according to the columns
			row[0] = ((Passenger) passengersArrayList.get(counter)).getFirstName();
			row[1] = ((Passenger) passengersArrayList.get(counter)).getSurname();
			row[2] = ((Passenger) passengersArrayList.get(counter)).getDateOfBirth();
			row[3] = ((Passenger) passengersArrayList.get(counter)).getTicketNumber();
			row[4] = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalBagCost();
			row[5] = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalTicketCost();
			row[6] = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalRestaurantCost();
			row[7] = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalShopCost();
			row[8] = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getCompensation();
			row[9] = ((Passenger) passengersArrayList.get(counter)).getPassenger_finance().getTotalOverallCost();
			model.addRow(row);
		}
	}
}
