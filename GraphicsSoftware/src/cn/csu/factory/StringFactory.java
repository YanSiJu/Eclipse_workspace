package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class StringFactory extends ShapeFactory {
	private String str = "��������";

	public StringFactory(int x1, int y1, int x2, int y2, Color color, BasicStroke s) {
		super(x1, y1, x2, y2, color, s);

	}

	@Override
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke());// ���ʴ�С
		g.setColor(getColor());// ���û�����ɫ

		g.drawString(str, getX1(), getY1());// ����

	}

}
