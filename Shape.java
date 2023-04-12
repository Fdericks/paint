

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	private int x;
	private int y;
	private int height;
	private int width;
	private Color shapeColor;
	private int initialX;
	private int initialY;
	private int newX;
	private int newY;
	
	public Shape() {
	}

	public Shape(int initialX, int initialY, int finalX, int finalY, Color color) {

		this.initialX = initialX;
		this.initialY = initialY;
		this.newX = finalX;
		this.newY = finalY;
		this.shapeColor = color;
		calculateQuadrant();
	}
	
	public Color getShapeColor() {
		return shapeColor;
	}
	public void setShapeColor(Color newShapeColor) {
		shapeColor = newShapeColor;
	} 
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getInitialX() {
		return initialX;
	}

	public void setInitialX(int initialX) {
		this.initialX = initialX;
	}

	public int getInitialY() {
		return initialY;
	}

	public void setInitialY(int initialY) {
		this.initialY = initialY;
	}

	public int getNewX() {
		return newX;
	}

	public void setNewX(int newX) {
		this.newX = newX;
	}

	public int getNewY() {
		return newY;
	}

	public void setNewY(int newY) {
		this.newY = newY;
	}


	public abstract void draw(Graphics g);
	
	public void calculateQuadrant() {

		int deltaX = Math.abs(initialX - newX);
		int deltaY = Math.abs(initialY - newY);

		//checks which quadrant the shape was drawn in and puts the proper parameters to draw it.
		if ((newX - initialX) > 0 && (newY - initialY) > 0) { //IV Quadrant
			x = initialX;
			y = initialY;
			height = deltaY;
			width = deltaX;
		} else if ((newX - initialX) < 0 && (newY - initialY) < 0) { // II quadrant }
			x = newX;
			y = newY;
			height = deltaY;
			width = deltaX;
		} else if ((newX - initialX) > 0 && (newY - initialY) < 0) { // I quadrant
			x = initialX;
			y = initialY - deltaY;
			height = deltaY;
			width = deltaX;
		} else if ((newX - initialX) < 0 && (newY - initialY > 0)) { // III quadrant
			x = initialX - deltaX;
			y = initialY;
			height = deltaY;
			width = deltaX;
		} else { // invalid shape
			x = initialX;
			y = initialY;
			height = 0;
			width = 0;
		}
	}
}
