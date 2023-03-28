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

		// define JFrame
		JFrame mainFrame = new JFrame("Paint");
		mainFrame.setSize(700, 700);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// define colors

		// define buttons with action listeners
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		JButton redBtn = new JButton("Red");
		ActionListener redAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button Clicked");
				// easier access to components.

			}
		};
		redBtn.addActionListener(redAL);
		buttons.add(redBtn);

		JButton blackBtn = new JButton("Black");
		ActionListener blackAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};
		blackBtn.addActionListener(blackAL);
		buttons.add(blackBtn);

		
		JButton rectBtn = new JButton("Rectangle");
		ActionListener rectAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		
		};
		rectBtn.addActionListener(rectAL);
		buttons.add(rectBtn);
		
	



		// define panel and layout

		JPanel mainPanel = new JPanel();

       
        //button panel setup
		JPanel buttonPanel = new JPanel();
		
		for (JButton button: buttons) {
			buttonPanel.add(button);
		}

		//canvas setup
		int canvasHeight = 600;
		int canvasWidth = 685;
		Canvas canvas = new Canvas(canvasWidth,canvasHeight);
		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		
		
		
		//layout setup
		GroupLayout layout = new GroupLayout(mainPanel);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        mainPanel.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(buttonPanel).addComponent(canvas)));
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
