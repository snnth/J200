public class WriteMe {

	public static void methodB() {
		methodA();
	}


	public static void methodA() {
		throw new ArrayIndexOutOfBoundsException("0");
	}

	public static void main(String[] args) {
		methodB();
	}
}
