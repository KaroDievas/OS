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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -212, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -378, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PTR");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -238, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, textField);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 56, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("MR");
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 1, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, textField);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IP");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 56, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DS");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 56, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CS");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 6, SpringLayout.SOUTH, textField_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 6, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, textField_4, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("SP");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 35, SpringLayout.EAST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_5, 6, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, textField_5, 6, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.EAST, textField_5, 52, SpringLayout.EAST, textField);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("SI");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 43, SpringLayout.EAST, textField_2);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TI");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_7, 21, SpringLayout.EAST, lblNewLabel_6);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("IOI");
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("PI");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_9, 207, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_9, -208, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_8, -10, SpringLayout.WEST, lblNewLabel_9);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_6, 6, SpringLayout.SOUTH, lblNewLabel_6);
		springLayout.putConstraint(SpringLayout.WEST, textField_6, 64, SpringLayout.EAST, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_6, -20, SpringLayout.EAST, lblNewLabel_7);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_7, 6, SpringLayout.SOUTH, lblNewLabel_7);
		springLayout.putConstraint(SpringLayout.WEST, textField_7, 5, SpringLayout.EAST, textField_6);
		springLayout.putConstraint(SpringLayout.EAST, textField_7, -276, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_8, -34, SpringLayout.EAST, textField_8);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_8, -6, SpringLayout.NORTH, textField_8);
		springLayout.putConstraint(SpringLayout.NORTH, textField_8, 137, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_8, 6, SpringLayout.EAST, textField_7);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_9, 202, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_8, -5, SpringLayout.WEST, textField_9);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, -6, SpringLayout.NORTH, textField_9);
		springLayout.putConstraint(SpringLayout.NORTH, textField_9, 137, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_9, -199, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_10, 122, SpringLayout.EAST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, textField_10, 156, SpringLayout.EAST, lblNewLabel_4);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblMode = new JLabel("MODE");
		springLayout.putConstraint(SpringLayout.NORTH, textField_10, 9, SpringLayout.SOUTH, lblMode);
		springLayout.putConstraint(SpringLayout.NORTH, lblMode, 3, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.WEST, lblMode, 90, SpringLayout.EAST, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, lblMode, 124, SpringLayout.EAST, textField_3);
		frame.getContentPane().add(lblMode);
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 31, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textArea, -145, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 64, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, textArea, -53, SpringLayout.EAST, frame.getContentPane());
		textArea.setRows(5);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_10 = new JLabel("MEMORY");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_10, -80, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("Vykdyti");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -169, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
	}
}
