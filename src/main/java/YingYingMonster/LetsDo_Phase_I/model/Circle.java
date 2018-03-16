package YingYingMonster.LetsDo_Phase_I.model;

import java.awt.Color;
import java.util.ArrayList;

public class Circle implements Requirement{
	/*
	 * @param color颜色 shape形状 thickness粗细
	 */
	ArrayList<Color> colorList;
	shape shape;
	int thickness;
	
	public Circle(ArrayList<Color> colorList, int thickness) {
		super();
		this.colorList = colorList;
		this.shape = shape.circle;
		this.thickness = thickness;
	}

	@Override
	public ArrayList<Color> getColor() {
		// TODO 自动生成的方法存根
		return colorList;
	}

	@Override
	public shape getShape() {
		// TODO 自动生成的方法存根
		return shape;
	}

	@Override
	public int getThickness() {
		// TODO 自动生成的方法存根
		return thickness;
	}
	
}
