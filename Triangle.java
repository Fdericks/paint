package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Triangle extends Shape{

	public Triangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX,initialY,finalX,finalY,color);
	}

	@Override
	public void draw(Graphics g) {
	//	int [] x = {getX() + (getWidth())/2,getX() + getWidth(),getX()}; // the three points of the triangle in (x,y)
	//	int [] y = {getY() + -getHeight(),getY(),getY()};
		// height needs to be negative b/c upside down coordinate plane
	//	g.fillPolygon(x, y, 3);
		
		Polygon triangle =new Polygon();
		triangle.addPoint(getInitialX()+(getNewX()-getInitialX())/2, getNewY());
		triangle.addPoint(getInitialX(), getInitialY());
		triangle.addPoint(getNewX(), getInitialY());
		
		g.fillPolygon(triangle);
	}
	
	
}
