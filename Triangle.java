package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Triangle extends Shape {

	public Triangle() {
	}

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
