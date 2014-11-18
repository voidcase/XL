package tester;

import java.awt.BorderLayout;
import java.awt.Color;

import gui.BorderPanel;
import gui.StatusLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class LabelTest extends JFrame {
	

	public LabelTest() {
		super("Label");
		StatusLabel label = new StatusLabel();
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.setBackground(Color.BLACK);
	
		panel.add(label);
		
		add(CENTER, panel);
//		panel.setOpaque(true);
//		label.setOpaque(true);
		pack();
		label.setText("Hej");
        label.setOpaque(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LabelTest();

	}
}
