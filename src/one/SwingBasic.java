package one;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class SwingBasic extends JFrame {
	JLabel l;
	JLabel l1;
	JLabel l2;
	JLabel l3;

	public void start() {
		
		l = new JLabel();
		l.setText(" Name :");
		final JTextField txt = new JTextField(10);

		l1 = new JLabel();
		l1.setText(" Father's Name :");
		final JTextField txt1 = new JTextField(10);

		l2 = new JLabel();
		l2.setText(" Address :");
		final JTextField txt2 = new JTextField(10);

		l3 = new JLabel();
		l3.setText(" DOB (DD-MM-YYYY) :");
		final JTextField txt3 = new JTextField(10);

		// JPasswordField ps = new JPasswordField(10);
		JButton but = new JButton();
		but.setText("Submit");
		add(l);
		add(txt);
		add(l1);
		add(txt1);
		add(l2);
		add(txt2);
		add(l3);
		add(txt3);
		// add(ps);
		add(but);
		/*
		 * txt.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { System.out.println(txt.getText()); }
		 * });
		 */

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// l.setText("Button clicked");
				HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
				Fields fields = new Fields();
				fields.setName(txt.getText());
				fields.setFathersName(txt1.getText());
				fields.setAddress(txt2.getText());
				fields.setDateOfBirth(txt3.getText());
				txt.setText("");
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");

				helloWorldPrinter.fill(fields);
			//	System.out.println(txt.getText());
			}
		});

		setLayout(new FlowLayout());
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String args[]) {
		new SwingBasic().start();
	}
}
