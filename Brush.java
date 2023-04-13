package groupProject.paint.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Brush extends Shape {

	ArrayList<Point> points = new ArrayList<Point>();

	private float brushWidth; // default brush width is 10f

	public Brush() {

	}

	public Brush(ArrayList<Point> points, Color color, float brushWidth) {
		this.points = points;
		setShapeColor(color);
		this.brushWidth = brushWidth;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getShapeColor());
		g2.setStroke(new BasicStroke(brushWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		for (int i = 1; i < points.size(); i++)
			g2.draw(new Line2D.Float(points.get(i - 1), points.get(i)));
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
	
}
