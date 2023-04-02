package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel { // specialized JPanel

	private int width;
	private int height;

	private int initialX;
	private int initialY;

	private Color currentColor = Color.BLACK;

	private String currentShape;

	public void setColor(Color newColor) {
		currentColor = newColor;
	}
	public Color getColor() {
		return currentColor;
	}
	
	public void setCurrentShape(String newShape) {
		currentShape = newShape;
	}

	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;

		/*
		 * Rectangle r; Rectangle r1; Rectangle r2; Rectangle r3;
		 * 
		 * r = new Rectangle(10, 10, 50, 50); shapes.add(r);
		 * 
		 * r1 = new Rectangle(20, 20, 50, 50); shapes.add(r1); r2 = new Rectangle(10,
		 * 50, 40, 70); shapes.add(r2); r3 = new Rectangle(30, 100, 20, 10);
		 * shapes.add(r3);
		 * 
		 * Circle c1 = new Circle(20, 30, 20, 20); Circle c2 = new Circle(200, 200, 30,
		 * 30); Circle c3 = new Circle(400, 410, 20, 20); shapes.add(c1);
		 * shapes.add(c2); shapes.add(c3);
		 */

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Mouse Released: " + e.getX());

				int currentX = e.getX();
				int currentY = e.getY();
				try {
				switch (currentShape) {
				case "Rectangle":
					createRect(currentX, currentY);
					break;
				case "Empty Rectangle":
					createEmptyRect(currentX, currentY);
					break;
				case "Triangle":
					createTriang(currentX,currentY);
					break;
				case "Circle":
					createCirc(currentX,currentY);
					break;
				case "Empty Circle":
					createEmptyCirc(currentX,currentY);
					break;
				case "Empty Triangle":
					createEmptyTriang(currentX, currentY);
					break;
				default:
					throw new RuntimeException("Shape not selected");
				}
				} catch (Exception error) {
					System.out.println("Select a shape. Once we add the brush method, this catch should check for the brush size and accordingly paint.");
				}
				repaint(); // calls paint component again

//				else if ((currentX-initialX)<0) && (currentY-initialY)>0 {
//					
//				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Mouse Pressed: " + e.getX());
				initialX = e.getX();
				initialY = e.getY();
			}

			@Override
			public void mouseExited(MouseEvent e) {
//				System.out.println("Mouse Exited: " + e.getX());

			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				System.out.println("Mouse Entered: " + e.getX()); // entering and exiting the frame.

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse Clicked: " + e.getX());
				Circle stroke = new Circle(e.getX()-5, e.getY()-5, 10, 10, currentColor);
				shapes.add(stroke);
				repaint();
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(0, 0, width, height);

		for (Shape shape : shapes) {
			g.setColor(shape.getShapeColor());
			shape.draw(g);
		}

	}

	private void createRect(int newX, int newY) {

		int deltaX = Math.abs(initialX - newX);
		int deltaY = Math.abs(initialY - newY);

		Rectangle rect;
		if ((newX - initialX) > 0 && (newY - initialY) > 0) { // IV quadrant
			rect = new Rectangle(initialX, initialY, deltaY, deltaX, currentColor);

		} else if ((newX - initialX) < 0 && (newY - initialY) < 0) { // II quadrant
			rect = new Rectangle(newX, newY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) > 0 && (newY - initialY) < 0) { // I quadrant
			rect = new Rectangle(initialX, initialY - deltaY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) < 0 && (newY - initialY > 0)) { // III quadrant
			rect = new Rectangle(initialX - deltaX, initialY, deltaY, deltaX, currentColor);
		} else { //invalid shape
			rect = new Rectangle(initialX, initialY, 0, 0, currentColor);
		}
		shapes.add(rect);
	}
	private void createEmptyRect(int newX, int newY) {

		int deltaX = Math.abs(initialX - newX);
		int deltaY = Math.abs(initialY - newY);

		EmptyRectangle empRect;		
		if ((newX - initialX) > 0 && (newY - initialY) > 0) { // IV quadrant
			empRect = new EmptyRectangle(initialX, initialY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) < 0 && (newY - initialY) < 0) { // II quadrant
			empRect = new EmptyRectangle(newX, newY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) > 0 && (newY - initialY) < 0) { // I quadrant
			empRect = new EmptyRectangle(initialX, initialY - deltaY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) < 0 && (newY - initialY > 0)) { // III quadrant
			empRect = new EmptyRectangle(initialX - deltaX, initialY, deltaY, deltaX, currentColor);
		} else { //invalid shape
			empRect = new EmptyRectangle(initialX, initialY, 0, 0, currentColor);
		}
		shapes.add(empRect);
	}
	private void createTriang(int newX,int newY) {
		
		Triangle triangle = new Triangle(initialX, initialY, newY, newX, currentColor);

		shapes.add(triangle);
	}
	
	private void createEmptyTriang(int newX,int newY) {
		
		EmptyTriangle empTriangle = new EmptyTriangle(initialX, initialY, newY, newX, currentColor);

		shapes.add(empTriangle);
	}
	
	
	private void createCirc(int newX, int newY) {

		int deltaX = Math.abs(initialX - newX);
		int deltaY = Math.abs(initialY - newY);

		Circle circ;		
		if ((newX - initialX) > 0 && (newY - initialY) > 0) { // IV quadrant
			circ = new Circle(initialX, initialY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) < 0 && (newY - initialY) < 0) { // II quadrant
			circ = new Circle(newX, newY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) > 0 && (newY - initialY) < 0) { // I quadrant
			circ = new Circle(initialX, initialY - deltaY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) < 0 && (newY - initialY > 0)) { // III quadrant
			circ = new Circle(initialX - deltaX, initialY, deltaY, deltaX, currentColor);
		} else { //invalid shape
			circ = new Circle(initialX, initialY, 0, 0, currentColor);
		}
		shapes.add(circ);
	}
	private void createEmptyCirc(int newX, int newY) {

		int deltaX = Math.abs(initialX - newX);
		int deltaY = Math.abs(initialY - newY);

		EmptyCircle empCirc;		
		if ((newX - initialX) > 0 && (newY - initialY) > 0) { // IV quadrant
			empCirc = new EmptyCircle(initialX, initialY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) < 0 && (newY - initialY) < 0) { // II quadrant
			empCirc = new EmptyCircle(newX, newY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) > 0 && (newY - initialY) < 0) { // I quadrant
			empCirc = new EmptyCircle(initialX, initialY - deltaY, deltaY, deltaX, currentColor);
		} else if ((newX - initialX) < 0 && (newY - initialY > 0)) { // III quadrant
			empCirc = new EmptyCircle(initialX - deltaX, initialY, deltaY, deltaX, currentColor);
		} else { //invalid shape
			empCirc = new EmptyCircle(initialX, initialY, 0, 0, currentColor);
		}
		shapes.add(empCirc);
	}
	

	private void createLine(int newX, int newY) {
		Line line;
	}
	
	private void calculateQuadrant(int newX,int newY){
		
		
	}
	}
