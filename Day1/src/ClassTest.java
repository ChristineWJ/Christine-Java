public class ClassTest {
	public static void main(String[] args) {
		// 打印输出九九乘法表
		/*
		 * int result = 0; for (int i = 1; i <= 9; i++) { for (int j = 1; j <= i; j++) {
		 * result = i * j; System.out.print(j + "*" + i + "=" + result + "\t"); result =
		 * 0; } System.out.println(); }
		 */

		/*
		 * int sum = 0; for(int i =1;i<=100;i++) { for(int j = 1;j<=i;j++) { sum+=j; } }
		 * System.out.println(sum);
		 */

		int sum = 0;
		int mutle = 1;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				mutle *= j;
			}
			sum += mutle;
			mutle = 1;
		}
		System.out.println(sum);

	}
}
