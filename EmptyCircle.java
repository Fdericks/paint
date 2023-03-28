package groupProject.paint.main;

import java.awt.Graphics;

public class EmptyCircle extends Shape {

	public EmptyCircle(int x, int y, int height, int width) {
		super(x, y, height, width);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());		
	}

}
