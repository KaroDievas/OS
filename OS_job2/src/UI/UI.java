package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class UI {

	private JFrame frame;
	private JTextField PTR;
	private JTextField MR;
	private JTextField IP;
	private JTextField DS;
	private JTextField CS;
	private JTextField SP;
	private JTextField SI;
	private JTextField TI;
	private JTextField IOI;
	private JTextField PI;
	private JTextField MODE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		PTR = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, PTR, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, PTR, -212, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, PTR, -378, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(PTR);
		PTR.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PTR");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -238, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, PTR, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, PTR);
		frame.getContentPane().add(lblNewLabel);
		
		MR = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, MR, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, MR, 56, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(MR);
		MR.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("MR");
		springLayout.putConstraint(SpringLayout.NORTH, MR, 1, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, PTR);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, PTR);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IP");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, MR);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_2);
		
		IP = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, IP, 6, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, IP, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, IP, 56, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(IP);
		IP.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DS");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, IP);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_3);
		
		DS = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, DS, 6, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, DS, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, DS, 56, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(DS);
		DS.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CS");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 6, SpringLayout.SOUTH, DS);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_4);
		
		CS = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, CS, 6, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, CS, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, CS, 0, SpringLayout.EAST, PTR);
		frame.getContentPane().add(CS);
		CS.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("SP");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 35, SpringLayout.EAST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_5);
		
		SP = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, SP, 6, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, SP, 6, SpringLayout.EAST, PTR);
		springLayout.putConstraint(SpringLayout.EAST, SP, 52, SpringLayout.EAST, PTR);
		frame.getContentPane().add(SP);
		SP.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("SI");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, IP);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 43, SpringLayout.EAST, IP);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TI");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH, IP);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_7, 21, SpringLayout.EAST, lblNewLabel_6);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("IOI");
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("PI");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_9, 207, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_9, -208, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_8, -10, SpringLayout.WEST, lblNewLabel_9);
		frame.getContentPane().add(lblNewLabel_9);
		
		SI = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, SI, 6, SpringLayout.SOUTH, lblNewLabel_6);
		springLayout.putConstraint(SpringLayout.WEST, SI, 64, SpringLayout.EAST, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.EAST, SI, -20, SpringLayout.EAST, lblNewLabel_7);
		frame.getContentPane().add(SI);
		SI.setColumns(10);
		
		TI = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, TI, 6, SpringLayout.SOUTH, lblNewLabel_7);
		springLayout.putConstraint(SpringLayout.WEST, TI, 5, SpringLayout.EAST, SI);
		springLayout.putConstraint(SpringLayout.EAST, TI, -276, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(TI);
		TI.setColumns(10);
		
		IOI = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_8, -34, SpringLayout.EAST, IOI);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_8, -6, SpringLayout.NORTH, IOI);
		springLayout.putConstraint(SpringLayout.NORTH, IOI, 137, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, IOI, 6, SpringLayout.EAST, TI);
		frame.getContentPane().add(IOI);
		IOI.setColumns(10);
		
		PI = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, PI, 202, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, IOI, -5, SpringLayout.WEST, PI);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, -6, SpringLayout.NORTH, PI);
		springLayout.putConstraint(SpringLayout.NORTH, PI, 137, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, PI, -199, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(PI);
		PI.setColumns(10);
		
		MODE = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, MODE, 122, SpringLayout.EAST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, MODE, 156, SpringLayout.EAST, lblNewLabel_4);
		frame.getContentPane().add(MODE);
		MODE.setColumns(10);
		
		JLabel lblMode = new JLabel("MODE");
		springLayout.putConstraint(SpringLayout.NORTH, MODE, 9, SpringLayout.SOUTH, lblMode);
		springLayout.putConstraint(SpringLayout.NORTH, lblMode, 3, SpringLayout.NORTH, DS);
		springLayout.putConstraint(SpringLayout.WEST, lblMode, 90, SpringLayout.EAST, DS);
		springLayout.putConstraint(SpringLayout.EAST, lblMode, 124, SpringLayout.EAST, DS);
		frame.getContentPane().add(lblMode);
		
		JTextArea MEMORY = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, MEMORY, 31, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, MEMORY, -145, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, MEMORY, 64, SpringLayout.SOUTH, IP);
		springLayout.putConstraint(SpringLayout.EAST, MEMORY, -53, SpringLayout.EAST, frame.getContentPane());
		MEMORY.setRows(5);
		frame.getContentPane().add(MEMORY);
		
		JLabel lblNewLabel_10 = new JLabel("MEMORY");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_10, -80, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_10);
		
		JButton Run = new JButton("Vykdyti");
		springLayout.putConstraint(SpringLayout.SOUTH, Run, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, Run, -169, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(Run);
	}
}
