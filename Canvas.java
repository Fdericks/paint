package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		g.fillRect(ALLBITS, ABORT, WIDTH, HEIGHT);
		g.setColor(Color.blue);
		g.drawRect(0,0,500,500);
		
	}
}
