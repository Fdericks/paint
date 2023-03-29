package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyCircle extends Shape {

	public EmptyCircle(int x, int y, int height, int width,Color color) {
		super(x, y, height, width,color);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());		
	}

}
