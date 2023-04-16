package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is the blueprint for individual shapes.
 * The Shape class is responsible for keeping track of the points,
 * height, and width of a shape. 
 * Shape class allows shape to be drawn in any direction. 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
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

		setInitialX(initialX);
		setInitialY(initialY);
		setNewX(finalX);
		setNewY(finalY);
		setShapeColor(color);
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

	/**
	 * Shape will draw according to specific coordinates
	 * @param Graphics g
	 */
	public abstract void draw(Graphics g);

	/**
	 * This method calculates the width and height of shape being drawn using the 
	 * initial and final (x,y) points. 
	 * This method reassigns the initial (x,y) coordinates based on 
	 * what direction/quadrant the user draws the shape.
	 * To find what quadrant the user drew in, the initial click of the user's mouse
	 * is considered the origin  
	 */
	public void calculateQuadrant() {

		width = Math.abs(initialX - newX);
		height = Math.abs(initialY - newY);

		// checks which quadrant the shape was drawn in and puts the proper parameters
		// to draw it.
		if ((newX - initialX) > 0 && (newY - initialY) > 0) { // IV Quadrant
			x = initialX;
			y = initialY;
		} else if ((newX - initialX) < 0 && (newY - initialY) < 0) { // II quadrant }
			x = newX;
			y = newY;
		} else if ((newX - initialX) > 0 && (newY - initialY) < 0) { // I quadrant
			x = initialX;
			y = initialY - height;
		} else if ((newX - initialX) < 0 && (newY - initialY > 0)) { // III quadrant
			x = initialX - width;
			y = initialY;
		} else { // invalid shape
			x = initialX;
			y = initialY;
			height = 0;
			width = 0;
		}
	}
}