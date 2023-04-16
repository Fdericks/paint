package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/** 
 * EmptyTriangle class is responsible for drawing a hollow triangle to the canvas 
 * based on user's start and end points. EmptyTriangle class inherits from Shape.
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class EmptyTriangle extends Shape {

	public EmptyTriangle() {
	}

	public EmptyTriangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);
	}

	@Override
	public void draw(Graphics g) {

		Polygon triangle = new Polygon();
		triangle.addPoint(getInitialX() + (getNewX() - getInitialX()) / 2, getNewY());
		triangle.addPoint(getInitialX(), getInitialY());
		triangle.addPoint(getNewX(), getInitialY());

		g.drawPolygon(triangle);
	}
}
