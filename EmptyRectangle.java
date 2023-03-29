package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyRectangle extends Shape {

	public EmptyRectangle(int x, int y, int width, int height,Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(getX(), getY(), getWidth(), getHeight());

	}
}
