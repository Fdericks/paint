

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	public Line() {
		
	}

	public Line(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);
	
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(getInitialX(), getInitialY(), getNewX(), getNewY());
	}

}
