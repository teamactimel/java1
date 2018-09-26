package ie.ait.week3;

import javax.swing.*;    // Needed for Swing classes

import java.awt.HeadlessException;
import java.awt.event.*; // action listener

public class KPLCalc extends JFrame {
	
	private JPanel panel;
	private JLabel tankSizeLabel;
	private JLabel kiloPerTankLabel;

	private JTextField kiloPerTankText;
	private JTextField tankSizeText;
	private JButton CalcKPL;
	
	private final int WINDOW_WIDTH = 400;  
	private final int WINDOW_HEIGHT = 200; 
	
	//the constructor
	public  KPLCalc() {
		
		setTitle("Calculate Kilometers per litre");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		add(panel);
		
		//never forget to set visible to true
		setVisible(true);
	}
	
	
	//Builds the panel and adds components
	private void buildPanel(){
		
		tankSizeLabel = new JLabel("Enter your cars tank size");
		kiloPerTankLabel = new JLabel("how many KM can you travel in one tank full");
		
		kiloPerTankText = new JTextField(10);
		tankSizeText = new JTextField(10);
		
		CalcKPL = new JButton ("Calculate");
		CalcKPL.addActionListener(new CalcButtonListener());
		
		panel = new JPanel();
		
		panel.add(tankSizeLabel);		panel.add(tankSizeText);
		panel.add(kiloPerTankLabel);	panel.add(kiloPerTankText);
		panel.add(CalcKPL);		
	}
	
//	listens for activity wit the calculate button
	
	private class CalcButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Double t = null;
			Double k = null;

			try {
				t = Double.parseDouble(tankSizeText.getText());
			} catch (NumberFormatException tankSizeException) {
				JOptionPane.showMessageDialog(null, "There was a problem with your input for Tank Size");
			}

			try {
				k = Double.parseDouble(kiloPerTankText.getText());
			} catch (NumberFormatException kptException) {
				JOptionPane.showMessageDialog(null,"There was a problem with your input for Kilometres Per Tank");
			}

			Double kpl = k / t;
			JOptionPane.showMessageDialog(null, "KPL= " + kpl);
		}// end Action performed
	}// end clas for buttonlistener
	   
	
	

	public static void main(String[] args) {
		new KPLCalc();

	}// end main

}// end KPLCalc class
