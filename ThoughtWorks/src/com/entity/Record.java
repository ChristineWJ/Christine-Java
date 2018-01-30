package com.entity;

/**
 * 飞机状态记录类
 * 
 * @author christine
 * 
 *
 */
public class Record {
	public static final String RIGHT = "正常";
	public static final String WRONG = "故障";

	private int num;
	private String message;
	private Axis curAxis;
	private String state;

	/**
	 * @param num
	 * @param message
	 * @param curAxis
	 * @param state
	 */
	public Record(int num, String message, Axis curAxis, String state) {
		super();
		this.num = num;
		this.message = message;
		this.curAxis = curAxis;
		this.state = state;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Axis getCurAxis() {
		return curAxis;
	}

	public void setCurAxis(Axis curAxis) {
		this.curAxis = curAxis;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "" + num + "," + message + "," + curAxis + "," + state;
	}
}