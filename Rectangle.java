package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	public Rectangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX,initialY,finalX,finalY,color);

	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(getX(), getY(), getWidth(), getHeight());

	}
}
