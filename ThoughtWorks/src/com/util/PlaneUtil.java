package com.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.entity.Axis;
import com.entity.Record;

/**
 * 无人机相关操作的工具类
 * 
 * @author christine
 *
 */
public class PlaneUtil {
	public static String file = "input.txt";
	public static List<String> input;
	public static List<Record> records;

	/**
	 * 从输入文件中读取消息记录
	 * 
	 * @return 消息记录列表
	 */
	public static List<String> readFromFile() {
		List<String> result = new ArrayList();
		BufferedReader bufferedReader = null;
		try {
			String line;
			bufferedReader = new BufferedReader(new FileReader(file));
			while ((line = bufferedReader.readLine()) != null) {
				result.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * 依据输入的消息计算飞机状态
	 * 
	 * @return 飞机状态记录列表
	 */
	public static List<Record> cacuState() {
		records = new ArrayList();
		int i;
		int cur = 0;
		boolean isRight = false;
		Iterator iter = input.iterator();

		// 第一条消息特殊处理
		String firstLine = (String) iter.next();
		String[] split = firstLine.split(" ");
		if (split.length == 4 && planeIDTest(split[0])) {
			for (i = 1; i < 4 && axisTest(split[i]); i++)
				;
			if (i == 4)
				isRight = true;
		}
		if (isRight)
			records.add(new Record(cur, firstLine,
					new Axis(Integer.valueOf(split[1]), Integer.valueOf(split[2]), Integer.valueOf(split[3])),
					Record.RIGHT));
		else
			records.add(new Record(cur, firstLine,
					new Axis(Integer.valueOf(split[1]), Integer.valueOf(split[2]), Integer.valueOf(split[3])),
					Record.WRONG));
		// 第一条消息特殊处理

		
		
		
		
		
		// 其他消息处理
		while (iter.hasNext()) {
			cur++;
			String line = (String) iter.next();
			split = line.split(" ");
			if (split.length == 7 && planeIDTest(split[0])) {
				for (i = 1; i < 7 && axisTest(split[i]); i++)
					;
				if (records.get(cur - 1).getState().equals(Record.RIGHT) && i == 7) {
					Record preRecord = records.get(cur - 1);
					Axis preAxis = preRecord.getCurAxis();
					Axis inputPreAxis = new Axis(Integer.valueOf(split[1]), Integer.valueOf(split[2]),
							Integer.valueOf(split[3]));
					int[] offsets = { Integer.valueOf(split[4]), Integer.valueOf(split[5]), Integer.valueOf(split[6]) };
					if (axisTest(preAxis, inputPreAxis)) {
						records.add(new Record(
								cur, line, new Axis(Integer.valueOf(split[1]) + offsets[0],
										Integer.valueOf(split[2]) + offsets[1], Integer.valueOf(split[3]) + offsets[2]),
								Record.RIGHT));
						continue;
					}
				}
			}
			records.add(new Record(cur, line,
					new Axis(Integer.valueOf(split[1]), Integer.valueOf(split[2]), Integer.valueOf(split[3])),
					Record.WRONG));
		}

		return records;
	}

	/**
	 * 根据要求判断并返回打印信息
	 * 
	 * @param id
	 * @return
	 */
	public static String judge(int id) {
		// 判断并打印
		if (id >= 0 && id < records.size()) {
			String msg;
			if (Record.RIGHT.equals(records.get(id).getState())) {
				msg = records.get(id).getMessage();
				return "" + msg.split(" ")[0] + " " + id + " " + records.get(id).getCurAxis();
			}
			return "Error: " + id;
		}
		return "Cannot find " + id;
	}

	/**
	 * 判断无人机id合法性
	 * 
	 * @param id
	 * @return
	 */
	public static boolean planeIDTest(String id) {
		String regex = "\\w+";
		return id.matches(regex);
	}

	/**
	 * 判断坐标合法性
	 * 
	 * @param x
	 * @return
	 */
	public static boolean axisTest(String x) {
		String regex = "\\d+";
		return x.matches(regex);
	}

	/**
	 * 判断当前坐标和前一坐标是否相等
	 * 
	 * @param preAxis
	 * @param inputPreAxis
	 * @return
	 */
	public static boolean axisTest(Axis preAxis, Axis inputPreAxis) {
		int[] pre = preAxis.getArray();
		int[] input = inputPreAxis.getArray();
		//int[] pre2= {preAxis.getX(),preAxis.getY(),preAxis.getZ()};
		int i;
		for (i = 0; i < 3; i++) {
			if (input[i] != pre[i])
				return false;
		}
		return true;
	}

}
