package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Line class is responsible for drawing a line to the canvas 
 * based on the user's press and release of the mouse.
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge 
 *
 */
public class Line extends Shape {

	/**
	 * Creates a new line
	 */
	public Line() {
	}

	/**
	 * Creates new line with initial and final (x,y) points based on
	 * the user's press and release of the mouse. 
	 * @param initialX - the x point based on the press of the user's mouse
	 * @param initialY - the y point based on the press of the user's mouse
	 * @param finalX - the x point based on the release of the user's mouse
	 * @param finalY - the y point based on the release of the user's mouse
	 * @param color - color the user chooses 
	 */
	public Line(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(getInitialX(), getInitialY(), getNewX(), getNewY());
	}

}
