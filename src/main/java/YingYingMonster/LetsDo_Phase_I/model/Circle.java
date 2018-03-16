package YingYingMonster.LetsDo_Phase_I.model;

import java.awt.Color;
import java.awt.Shape;

public class Circle implements Requirement{
	/*
	 * @param color颜色 shape形状 thickness粗细
	 */
	Color color;
	Shape shape;
	int thickness;
	
	public Circle(Color color, Shape shape, int thickness) {
		super();
		this.color = color;
		this.shape = shape;
		this.thickness = thickness;
	}

	@Override
	public Color getColor() {
		// TODO 自动生成的方法存根
		return color;
	}

	@Override
	public Shape getShape() {
		// TODO 自动生成的方法存根
		return shape;
	}

	@Override
	public int getThickness() {
		// TODO 自动生成的方法存根
		return thickness;
	}
	
}
