package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	public Circle(int x, int y, int height, int width, Color color) {
		super(x, y, height, width,color);
	}

	@Override
	public void draw(Graphics g) {

		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}
