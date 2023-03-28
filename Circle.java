package groupProject.paint.main;

import java.awt.Graphics;

public class Circle extends Shape {

	public Circle(int x, int y, int height, int width) {
		super(x, y, height, width);
	}

	@Override
	public void draw(Graphics g) {

		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}
