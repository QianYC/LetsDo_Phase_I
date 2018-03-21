package YingYingMonster.LetsDo_Phase_I.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Tag 标签类，记录了各种属性、语句、语句分词、几何标签
 * @author 17678
 *
 */
public class Tag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8721771397034622966L;

	private int type;
	
	private Map<String,String>tags;//各种属性的标签
	
	private byte[]bytes;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
}
