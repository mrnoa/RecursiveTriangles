import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Triangles extends Canvas {
	private JFrame pane;
	private Canvas canvas;
	private int height = 1000;
	private Polygon polygon;
	private int numberOfSteps = 6;

	public Triangles() {
		pane = new JFrame();
		setPreferredSize(new Dimension(height, height));
		setBackground(Color.WHITE);
		pane.add(this);
		pane.pack();
		pane.setVisible(true);
		this.addComponentListener(new AspectRatioEnforcer(1));

	}

	public static void main(String[] args) {
		Triangles triangles = new Triangles();
	}

	private void drawTriangles(int n, int[] origXPoints, int[] origYPoints, Graphics g) {
			int redValue =Math.min(255,n*255/numberOfSteps);
			g.setColor(new Color(255-redValue,255,0));
			int[] xPoints = { (origXPoints[0] + origXPoints[1]) / 2, (origXPoints[1] + origXPoints[2]) / 2,
					(origXPoints[2] + origXPoints[0]) / 2 };
			int[] yPoints = { (origYPoints[0] + origYPoints[1]) / 2, (origYPoints[1] + origYPoints[2]) / 2,
					(origYPoints[2] + origYPoints[0]) / 2 };
			Polygon polygon = new Polygon(xPoints, yPoints, 3);
			
			
			g.fillPolygon(polygon);
			g.setColor(Color.BLACK);
			g.drawPolygon(polygon);
			if (numberOfSteps -1 > n) {
			drawTriangles(n+1,new int[] { xPoints[0], xPoints[2], origXPoints[0] },
					new int[] { yPoints[0], yPoints[2], origYPoints[0] }, g);
			drawTriangles(n+1,new int[] { xPoints[1], xPoints[0], origXPoints[1] },
					new int[] { yPoints[1], yPoints[0], origYPoints[1] }, g);
			drawTriangles(n+1,new int[] { xPoints[2], xPoints[1], origXPoints[2] },
					new int[] { yPoints[2], yPoints[1], origYPoints[2] }, g);

			
		}
	}

	@Override
	public void paint(Graphics g) {
		height = getHeight();
		double s = 2 * (height / Math.sqrt(Math.sqrt(3) + 2));
		int x = (int) Math.round(Math.sqrt(Math.pow(s, 2) - Math.pow(height, 2)));
		int[] xPoints = { height, 0, height - x };
		int[] yPoints = { height, height - x, 0 };
		polygon = new Polygon(xPoints, yPoints, 3);
		// int[] middleXPoints = {(xPoints[0]+xPoints[1])/2,(xPoints[1]+xPoints[2])/2,(xPoints[2]+xPoints[0])/2 };
		// int[] middleYPoints = {(yPoints[0]+yPoints[1])/2,(yPoints[1]+yPoints[2])/2,(yPoints[2]+yPoints[0])/2 };
		// Polygon middleTriangle = new Polygon(middleXPoints, middleYPoints, 3);
		g.setColor(Color.black);
		g.drawPolygon(polygon);
		drawTriangles(0,xPoints, yPoints, g);
		// g.drawPolygon(middleTriangle);
	}

}
