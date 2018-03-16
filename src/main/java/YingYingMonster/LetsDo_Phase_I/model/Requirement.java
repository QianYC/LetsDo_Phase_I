package YingYingMonster.LetsDo_Phase_I.model;

import java.awt.Color;
import java.util.ArrayList;

public interface Requirement {
	enum shape {rec,circle,irregular}
	public ArrayList<Color> getColor();
	public int getThickness();
	public shape getShape();
}
