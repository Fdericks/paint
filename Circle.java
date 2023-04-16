package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Circle class is responsible for drawing a filled circle to the canvas 
 * based on user's press and release of the mouse.
 * Circle inherits from Shape. 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class Circle extends Shape {

	public Circle() {
	}

	public Circle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);

	}

	@Override
	public void draw(Graphics g) {
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}
