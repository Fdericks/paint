package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyTriangle extends Shape{

	public EmptyTriangle(int x, int y, int height, int width, Color color) {
		super(x, y, height, width,color);
	}

	@Override
	public void draw(Graphics g) {
		int [] x = {getX() + (getWidth())/2,getX() + getWidth(),getX()}; // the three points of the triangle in (x,y)
		int [] y = {getY() + -getHeight(),getY(),getY()};
		// height needs to be negative b/c upside down coordinate plane
		g.drawPolygon(x, y, 3);
	}
}