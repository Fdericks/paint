package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * EmptyCircle class is responsible for drawing a hollow circle to the canvas 
 * based on user's press and release of the mouse.
 * EmptyCircle inherits from Shape. 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class EmptyCircle extends Shape {

	/**
	 * Creates a new hollow circle
	 */
	public EmptyCircle() {
	}

	/**
	 * Creates new hollow circle with initial and final (x,y) points based on
	 * the user's press and release of the mouse. 
	 * @param initialX - the x point based on the press of the user's mouse
	 * @param initialY - the y point based on the press of the user's mouse
	 * @param finalX - the x point based on the release of the user's mouse
	 * @param finalY - the y point based on the release of the user's mouse
	 * @param color - color the user chooses 
	 */
	public EmptyCircle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);

	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}

}
