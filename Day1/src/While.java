import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class While {
	public static void main(String[] args) {
		/*
		 * int oddSum = 0; //奇数的和 int evenSum=0; //偶数的和 for(int i = 0;i<=100;i++) {
		 * if(i%2!=0) { oddSum+=i; }else { evenSum+=i; } }
		 * System.out.println("奇数的和： "+oddSum); System.out.println("偶数的和： "+evenSum);
		 */
		//方法一
		/*for(int i =1;i<=5000;i++) {
			if(i%5==0) {
				System.out.print(i+" ");
			}
			if(i%15==0) {
				System.out.println();
			}
		}*/
		//方法二
		ArrayList<Integer> list = new ArrayList();
		for(int i =1;i<=50;i++) {
			if(i%5==0) {
				list.add(i);
			}
			if(3==list.size()) {
				Iterator iter = list.iterator();
				while(iter.hasNext()) {
					System.out.print(iter.next()+" ");
				}
				list.clear();
				System.out.println();
			}
		}
		
	}
}
