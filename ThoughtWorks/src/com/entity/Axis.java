package com.entity;

/**
 * 坐标类
 * 
 * @author christine
 * 
 */
public class Axis {
	private int x=0, y=0, z;

	public Axis(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public int[] getArray() {
		int[] result= {x,y,z};
		return result;
	}
	@Override
	public String toString() {
		return "" + x + " " + y + " " + z;
	}
}