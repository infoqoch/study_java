package effective.c22;

public class ConstInterfaceImpl implements ConstInterface {

	public static void main(String[] args) {
		int age = ConstInterfaceImpl.AGE; // 평생 관리해야 한다.
		System.out.println(age);
	}
}
