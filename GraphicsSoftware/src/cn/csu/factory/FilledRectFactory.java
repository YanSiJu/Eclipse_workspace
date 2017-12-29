package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class FilledRectFactory extends ShapeFactory {

	public FilledRectFactory(DrawListenerner listenerner) {
		super(Math.min(listenerner.getX1(), listenerner.getX2()), Math.min(listenerner.getY1(), listenerner.getY2()),
				Math.abs(listenerner.getX1() - listenerner.getX2()),
				Math.abs(listenerner.getY1() - listenerner.getY2()), listenerner.getColorStr(), new BasicStroke(1));
	}

	/**
	 * ����ͼ�εķ���
	 * 
	 * @param g���ʶ���
	 */
	@Override
	public void draw(Graphics2D g) {
		// ���û��ʵĴ�ϸ
		g.setStroke(getStroke());
		// ���û�����ɫ
		c.setGraphicsColor(g);
		// ���ƾ���
		g.fillRect(getX1(), getY1(), getX2(), getY2());
	}

}
