package bercy.tools;

import java.util.Scanner;

public class ScannerChoice {

	/**
	 * get keyboard type in number
	 * @return
	 */
	public static String ScannerInfoString() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter:");
		return sc.next();
	}
}
