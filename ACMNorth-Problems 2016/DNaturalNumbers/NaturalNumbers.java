import java.util.Scanner;
import java.lang.Math;

public class NaturalNumbers {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int t = Integer.parseInt(input.nextLine());

		String line = input.nextLine();
		String[] X = line.split("\\s+");

		for(int i=0; i<X.length; i++) {
			
			double x = Double.parseDouble(X[i]);

			if(x < 0) {
				System.out.print("N");
				continue;
			}

			double y = Math.ceil(x);
			double k = x-y;

			if((k > 0.0) || (k < 0.0))
				System.out.print("N");
			else
				System.out.print("Y");

		}

	}

}