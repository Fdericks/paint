package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	public Circle() {
	}

	public Circle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);

	}

	@Override
	public void draw(Graphics g) {
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}
