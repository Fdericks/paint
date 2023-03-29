package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	public Rectangle(int x, int y, int height, int width, Color color) {
		super(x, y, height, width,color);
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(getX(), getY(), getWidth(), getHeight());

	}
}
