package groupProject.paint.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Brush is responsible for drawing lines based on the dragging of the user's mouse 
 * after the user's initial press if no shape was selected by the user or if the user
 * selects the brush.
 * User can select various brush width sizes. 
 * 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class Brush extends Shape {

	ArrayList<Point> points = new ArrayList<Point>();

	private float brushWidth; // default brush width is 10f
	private float defaultBrushWidth = 1;

	/**
	 * Creates a new brush
	 */
	public Brush() {

	}

	/**
	 * Creates a new brush
	 * @param points - list of points that are saves as the user drags the mouse 
	 * @param color - color of the brush
	 * @param brushWidth- width of the brush
	 */
	public Brush(ArrayList<Point> points, Color color, float brushWidth) {
		this.points = points;
		setShapeColor(color);
		this.brushWidth = brushWidth;
	}

	@Override
	public void draw(Graphics g) {
		//creates new graphics2D for brush to work with, it casts the usual graphics into Graphics 2D.
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getShapeColor());
		g2.setStroke(new BasicStroke(brushWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		//create a line for each two points stored 
		for (int i = 1; i < points.size(); i++)
			g2.draw(new Line2D.Float(points.get(i - 1), points.get(i)));
		
		//setStroke needs to be set back to default to avoid problems with the empty shapes and lines.
		g2.setStroke(new BasicStroke(defaultBrushWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	}
	
	public void addPoint(Point p) {
		points.add(p);
	}

	public float getBrushWidth() {
		return brushWidth;
	}

	public void setBrushWidth(float brushWidth) {
		this.brushWidth = brushWidth;
	}
	
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	
}
