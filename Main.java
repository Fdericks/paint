package groupProject.paint.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {

		// define JFrame
		JFrame mainFrame = new JFrame("Paint");
		mainFrame.setSize(700, 700);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// define colors

		// define buttons with action listeners
		JButton redBtn = new JButton("Red");
		ActionListener redAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button Clicked");
				// easier access to components.

			}
		};
		redBtn.addActionListener(redAL);

		JButton blackBtn = new JButton("Black");
		ActionListener blackAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};


		// define panel and layout

		JPanel mainPanel = new JPanel();

		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(blackBtn);
		buttonPanel.add(redBtn);

		Canvas canvas = new Canvas();
		
		
		mainPanel.add(buttonPanel);
		mainPanel.add(canvas);
		mainFrame.add(mainPanel);

		mainFrame.setVisible(true);
	}

}
