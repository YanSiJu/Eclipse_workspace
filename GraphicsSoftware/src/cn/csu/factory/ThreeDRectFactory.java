package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class ThreeDRectFactory extends ShapeFactory {

	public ThreeDRectFactory(int x1, int y1, int x2, int y2, Color color, BasicStroke s) {
		super(x1, y1, x2, y2, color, s);

	}

	@Override
	public void draw(Graphics2D g) {
		g.setStroke(g.getStroke());
		g.setColor(getColor());// ���û�����ɫ
		g.fill3DRect(getX1(), getY1(), getX2() - getX1(), getY2() - getY1(), true);
	}

	
	
}
