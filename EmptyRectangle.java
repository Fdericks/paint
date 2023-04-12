package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyRectangle extends Shape {

	public EmptyRectangle() {
	}

	public EmptyRectangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(getX(), getY(), getWidth(), getHeight());

	}
}
