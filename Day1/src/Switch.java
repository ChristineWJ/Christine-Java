public class Switch {
	public static void main(String[] args) {
		//字符
		char c = 'a';
		int rand = (int) (26 * Math.random());
		char c2 = (char) (c + rand);
		System.out.print(c2 + ": ");
		switch (c2) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println("元音");
			break;
		case 'y':
		case 'w':
			System.out.println("半元音");
			break;
		default:
			System.out.println("辅音");
			break;
		}
		//字符串
		String a = "曹文洁";
		switch (a) {
		case "代江海":
			System.out.println("输入的是代江海");
			break;
		case "曹文洁":
			System.out.println("输入的是曹文洁");
			break;
		default:
			System.out.println("大家好");
			break;
		}

	}
}