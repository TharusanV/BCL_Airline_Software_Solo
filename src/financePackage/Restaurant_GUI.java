package financePackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Restaurant_GUI extends JFrame {

	/*IF THERE IS AN ERROR PLEASE READ TO FIX - For some reason whenever I export then import this project errors appear so I think the JRE library is not imported correctly
	 * so to fix this go to Project->Properties->Java Build Path->Library->Delete the JRE system library under ModulePath->Add library->Select JRE System Library-> 
	 * Go to execution environment->From the drop down menu you select either the one at the bottom or 1.7 and it should work then*/
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurant_GUI frame = new Restaurant_GUI();
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
	public Restaurant_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel restaurantLabel = new JLabel("Restaurant Frame");
		restaurantLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		restaurantLabel.setBounds(96, 75, 526, 171);
		contentPane.add(restaurantLabel);
		
		JButton financeButton = new JButton("Finance");
		financeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose(); //Use if you want only one window / Don't if you want to have multiple windows
				Finance_GUI financeFrame = new Finance_GUI(); 
				financeFrame.setVisible(true);
			}
		});
		financeButton.setBounds(183, 210, 112, 23);
		contentPane.add(financeButton);
		
	}

}
