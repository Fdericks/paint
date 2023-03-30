package groupProject.paint.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {

		int frameWidth = 700; // pixel num.
		int frameHeight = 700;

		// define JFrame
		JFrame mainFrame = new JFrame("Paint");
		mainFrame.setSize(frameWidth, 700);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// define colors



		// define panel and layout

		JPanel mainPanel = new JPanel();

		// button panel setup

		// canvas setup
		int canvasHeight = 600;
		int canvasWidth = 685;
		Canvas canvas = new Canvas(frameWidth - 15, canvasHeight);
		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		
		
		
		
		
		// define buttons with action listeners

		ArrayList<JButton> buttons = new ArrayList<JButton>();

		JButton redBtn = new JButton("Red");
		ActionListener redAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button Clicked");
				canvas.setColor(Color.RED);
			}
		};
		redBtn.addActionListener(redAL);
		buttons.add(redBtn);

		JButton blackBtn = new JButton("Black");
		ActionListener blackAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.BLACK);
			}
		};
		blackBtn.addActionListener(blackAL);
		buttons.add(blackBtn);

		JButton rectBtn = new JButton("Rectangle");
		ActionListener rectAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape("Rectangle");
			}

		};
		rectBtn.addActionListener(rectAL);
		buttons.add(rectBtn);
		
		JButton emptyRectBtn = new JButton("Empty Rectangle");
		ActionListener emptyRectAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape("Empty Rectangle");
			}

		};
		emptyRectBtn.addActionListener(emptyRectAL);
		buttons.add(emptyRectBtn);
		
		
		
		
		JPanel buttonPanel = new JPanel();

		for (JButton button : buttons) {
			buttonPanel.add(button);
		}

		
		
		
		
		
		
		

		// layout setup
		GroupLayout layout = new GroupLayout(mainPanel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		mainPanel.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup().addComponent(buttonPanel).addComponent(canvas)));
		layout.setVerticalGroup(layout.createSequentialGroup().addComponent(buttonPanel).addComponent(canvas));

		/*
		 * JPanel p = new JPanel(); p.setPreferredSize(new Dimension(100, 100));
		 * p.setBackground(Color.BLACK);
		 * 
		 * mainPanel.add(p);
		 */

		mainFrame.add(mainPanel);

		mainFrame.setVisible(true);
	}

}
