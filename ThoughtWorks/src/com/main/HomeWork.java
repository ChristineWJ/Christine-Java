package com.main;

import java.util.Scanner;
import com.entity.Axis;
import com.entity.Record;
import com.util.PlaneUtil;

/**
 * main方法入口
 * 
 * @author christine
 *
 */

public class HomeWork {
	public static void main(String[] args) {
		PlaneUtil.input = PlaneUtil.readFromFile();
		PlaneUtil.records = PlaneUtil.cacuState();
		 int temp = 0;
		for(int i = 0;i<PlaneUtil.records.size();i++) {
			if(PlaneUtil.records.get(i).getState().equals(Record.WRONG)) {
				temp = i;
				break;
			}
		}
		System.out.println(temp);
		int j;
		int curx= 0,cury = 0,curz = 0;
		for(j = 1;j<temp;j++) {
			String[] split = PlaneUtil.records.get(j).getMessage().split(" ");
			//Axis curAxis = new Axis(Integer.valueOf(split[3]),Integer.valueOf(split[4]),Integer.valueOf(split[5]));
			curx = curx + Math.abs(Integer.valueOf(split[4]));
			cury = cury + Math.abs(Integer.valueOf(split[5]));
			curz = curz + Math.abs(Integer.valueOf(split[6]));
		}
		System.out.println(curx+" "+cury+" "+curz);
		
		int id;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			id=scanner.nextInt();
			if(id == -1) {
				System.out.println("exit...");
				break;
			}
			System.out.println(PlaneUtil.judge(id));
		}
		
		
	}
}
