package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class LineFactory extends ShapeFactory {

	public LineFactory(int x1, int y1, int x2, int y2, String color, BasicStroke stroke) {
		super(x1, y1, x2, y2, color, stroke);
	}

	public LineFactory(DrawListenerner listenerner) {
		super(listenerner);
		this.setStroke(new BasicStroke(1));
	}

	/**
	 * ����ͼ�εķ���
	 * 
	 * @param g���ʶ���
	 */
	@Override
	public void draw(Graphics2D g) {
		g.setStroke(getStroke());// ���û��ʵĴ�ϸ
		// ���û�����ɫ
		c.setGraphicsColor(g);
		g.drawLine(getX1(), getY1(), getX2(), getY2());// ����ֱ��
	}

}
