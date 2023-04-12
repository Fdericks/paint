

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class EmptyTriangle extends Shape{
	
	public EmptyTriangle() {
		
	}
	
	public EmptyTriangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX,initialY,finalX,finalY,color);
	}

	@Override
	public void draw(Graphics g) {
		/*
		int [] x = {getX() + (getWidth())/2,getX() + getWidth(),getX()}; // the three points of the triangle in (x,y)
		int [] y = {getY() + -getHeight(),getY(),getY()};
		// height needs to be negative b/c upside down coordinate plane
		g.drawPolygon(x, y, 3);
		*/
//		System.out.println(getWidth());
		Polygon triangle =new Polygon();
		triangle.addPoint(getX()+(getWidth()-getX())/2, getHeight());
		triangle.addPoint(getX(), getY());
		triangle.addPoint(getWidth(), getY());
		
		g.drawPolygon(triangle);
	}
}
