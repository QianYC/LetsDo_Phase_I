package YingYingMonster.LetsDo_Phase_I.model;

import java.awt.Color;
import java.util.ArrayList;

import YingYingMonster.LetsDo_Phase_I.model.Requirement.shape;

public class Rec implements Requirement {
	/*
	 * @param color颜色 shape形状 thickness粗细
	 */
	ArrayList<Color> colorList;
	shape shape;
	int thickness;

	@Override
	public ArrayList<Color> getColor() {
		// TODO 自动生成的方法存根
		return colorList;
	}

	public Rec(ArrayList<Color> colorList, int thickness) {
		super();
		this.colorList = colorList;
		this.shape=shape.rec;
		this.thickness = thickness;
	}

	@Override
	public int getThickness() {
		// TODO 自动生成的方法存根
		return thickness;
	}

	@Override
	public shape getShape() {
		// TODO 自动生成的方法存根
		return shape;
	}

}
