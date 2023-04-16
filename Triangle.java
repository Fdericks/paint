package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Triangle class is responsible for drawing a solid triangle to the canvas 
 * based on user's start and end points. Triangle class inherits from Shape. 
 * 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class Triangle extends Shape {

	/**
	 * Creates new solid triangle
	 */
	public Triangle() {
	}

	/**
	 * Creates new solid triangle with initial and final (x,y) points based on
	 * the user's press and release of the mouse. 
	 * @param initialX - the x point based on the press of the user's mouse
	 * @param initialY - the y point based on the press of the user's mouse
	 * @param finalX - the x point based on the release of the user's mouse
	 * @param finalY - the y point based on the release of the user's mouse
	 * @param color - color the user chooses 
	 */
	public Triangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);
	}

	@Override
	public void draw(Graphics g) {

		Polygon triangle = new Polygon();
		triangle.addPoint(getInitialX() + (getNewX() - getInitialX()) / 2, getNewY());
		triangle.addPoint(getInitialX(), getInitialY());
		triangle.addPoint(getNewX(), getInitialY());

		g.fillPolygon(triangle);
	}

}
