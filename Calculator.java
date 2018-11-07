import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator extends JFrame implements ActionListener {

	private static final long serialVersionUID = -5706149177371314031L;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b_eq, b_plus, b_minus, b_div, b_mult, b_cl;
	private int temp2 = -1, temp3 = 0; // temp3 = type of op, temp2 = what came before
	private double temp1, temp0; // store input numbers
	private JTextField tf;

	public Calculator() {

		GridLayout gl = new GridLayout(4, 4);

		JPanel mainPanel = new JPanel(gl);
		add(mainPanel, BorderLayout.CENTER);

		Font f = new Font("Verdana", Font.BOLD, 25);
		tf = new JTextField(10);
		tf.setHorizontalAlignment(SwingConstants.RIGHT);
		tf.setEditable(false);
		tf.setFont(f);
		add(tf, BorderLayout.NORTH);

		b7 = new JButton("7");
		makeButton(b7, mainPanel, f);

		b8 = new JButton("8");
		makeButton(b8, mainPanel, f);

		b9 = new JButton("9");
		makeButton(b9, mainPanel, f);

		b_div = new JButton("/");
		makeButton(b_div, mainPanel, f);

		b4 = new JButton("4");
		makeButton(b4, mainPanel, f);

		b5 = new JButton("5");
		makeButton(b5, mainPanel, f);

		b6 = new JButton("6");
		makeButton(b6, mainPanel, f);

		b_mult = new JButton("x");
		makeButton(b_mult, mainPanel, f);

		b1 = new JButton("1");
		makeButton(b1, mainPanel, f);

		b2 = new JButton("2");
		makeButton(b2, mainPanel, f);

		b3 = new JButton("3");
		makeButton(b3, mainPanel, f);

		b_minus = new JButton("-");
		makeButton(b_minus, mainPanel, f);

		b0 = new JButton("0");
		makeButton(b0, mainPanel, f);

		b_cl = new JButton("C");
		makeButton(b_cl, mainPanel, f);

		b_eq = new JButton("=");
		makeButton(b_eq, mainPanel, f);

		b_plus = new JButton("+");
		makeButton(b_plus, mainPanel, f);

	}

	public void actionPerformed(ActionEvent e) {

		String tfText = tf.getText();

		Scanner textScan = new Scanner(tfText);

		if (e.getSource() == b_cl) {
			temp2 = -1;
			temp3 = 0;
			tf.setText("");
		}

		if (tfText.length() < 10) {
			if (e.getSource() == b0) {
				makingOrder(tf, "0", tfText);
			} else if (e.getSource() == b1) {
				makingOrder(tf, "1", tfText);
			} else if (e.getSource() == b2) {
				makingOrder(tf, "2", tfText);
			} else if (e.getSource() == b3) {
				makingOrder(tf, "3", tfText);
			} else if (e.getSource() == b4) {
				makingOrder(tf, "4", tfText);
			} else if (e.getSource() == b5) {
				makingOrder(tf, "5", tfText);
			} else if (e.getSource() == b6) {
				makingOrder(tf, "6", tfText);
			} else if (e.getSource() == b7) {
				makingOrder(tf, "7", tfText);
			} else if (e.getSource() == b8) {
				makingOrder(tf, "8", tfText);
			} else if (e.getSource() == b9) {
				makingOrder(tf, "9", tfText);
			}
		}

		if (temp2 != 0) {
			if (e.getSource() == b_plus) {

				temp1 = textScan.nextDouble();
				tf.setText(String.format("%8.2f", temp1));
				temp3 = 1;

			} else if (e.getSource() == b_minus) {

				temp1 = textScan.nextDouble();
				tf.setText(String.format("%8.2f", temp1));
				temp3 = 2;

			} else if (e.getSource() == b_mult) {

				temp1 = textScan.nextDouble();
				tf.setText(String.format("%8.2f", temp1));
				temp3 = 3;

			} else if (e.getSource() == b_div) {

				temp1 = textScan.nextDouble();
				tf.setText(String.format("%8.2f", temp1));
				temp3 = 4;

			}
			temp2 = 0;
		}

		if (temp2 != 0 && e.getSource() == b_eq) {

			if (temp3 == 1) {
				temp0 = textScan.nextDouble();
				double result = temp1 + temp0; // temp1
				tf.setText(String.format("%8.2f", result));
			} else if (temp3 == 2) {
				temp0 = textScan.nextDouble();
				double result = temp1 - temp0;
				tf.setText(String.format("%8.2f", result));
			} else if (temp3 == 3) {
				temp0 = textScan.nextDouble();
				double result = temp1 * temp0;
				tf.setText(String.format("%8.2f", result));
			} else if (temp3 == 4) {
				temp0 = textScan.nextDouble();
				double result = temp1 / temp0;
				tf.setText(String.format("%8.2f", result));
			} else {
			}
			temp2 = 0;
			temp3 = 0;

		}
		textScan.close();
	}

	public void makingOrder(JTextField field, String string, String tfText) {
		if (temp2 != 0 && !field.getText().equals("0")) {
			field.setText(tfText + string);
		} else {
			field.setText(string);
		}
		temp2 = -1;
	}

	public void makeButton(JButton button, JPanel panel, Font font) {
		button.setPreferredSize(new Dimension(50, 50));
		panel.add(button);
		button.setFont(font);
		button.addActionListener(this);
	}

	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setVisible(true);
		frame.pack();
		frame.setTitle("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 400);
	}

}