import java.util.Scanner;

public class Perks {

	public static void transitiveClosure(boolean[][] perks)
	{
		int n = perks.length;
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					perks[i][j] = (perks[i][k]&perks[k][j])|perks[i][j];
				}
				//System.out.print((perks[i][j]? 1:0)+" ");
			}
			//System.out.println();
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				//if(i == j)
				//	continue;
				System.out.print((perks[i][j]? (i+1)+" "+(j+1)+" " : ""));
			}
			//=System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int t = Integer.parseInt(input.nextLine());

		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(input.nextLine());
			boolean[][] perks = new boolean[n][n];
			for(int j=0; j<n; j++)
				perks[j][j] = true;

			String line = input.nextLine();
			String[] e = line.split("\\s+");
			int k = e.length;
			for(int j=0; j<k; j++) {
				int u =  Integer.parseInt(e[j])-1;
				j++;
				int v =  Integer.parseInt(e[j])-1;
				perks[u][v] = true;
			}

			transitiveClosure(perks);
		}
	}

}
