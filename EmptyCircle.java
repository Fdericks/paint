package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyCircle extends Shape {

	public EmptyCircle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX,initialY,finalX,finalY,color);

	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());		
	}

}
