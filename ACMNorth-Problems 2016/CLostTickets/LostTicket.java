import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class LostTicket {

	private static int MAX_SIZE = 5000;


	public static int getId(Map<String, Integer> nameId, String name)
	{
		if(!nameId.containsKey(name))
			nameId.put(name, nameId.size());

		return nameId.get(name);
	
	}

	public static int reportLostTickets(Scanner input)
	{
		String line = input.nextLine();
		String[] fans = line.split("\\s+");
		int n = fans.length;

		Map<String, Integer> nameId = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			nameId.put(fans[i], i);
		}

		
		boolean[][] GiveClaim = new boolean[MAX_SIZE][MAX_SIZE];
		boolean[][] Giver = new boolean[MAX_SIZE][MAX_SIZE];

		int m = Integer.parseInt(input.nextLine()); 
		for(int i=0; i<m; i++) {
			line = input.nextLine();
			String[] commands = line.split("\\s+");

			if(commands[0].equals("G")) {
				int giverId = getId(nameId, commands[1]);
				int k = commands.length-2;
				for(int j=0; j<k; j++) {
					int receiverId = getId(nameId, commands[2+j]);
					GiveClaim[giverId][receiverId] = true;
					Giver[giverId][receiverId] = true;
				}
			} 
			else if(commands[0].equals("C")) {
				int claimerId = getId(nameId, commands[1]);
				int giverId = getId(nameId, commands[2]);
				GiveClaim[claimerId][giverId] = true;

			}
		}

		int max = nameId.size();
		for(int i=0; i<max; i++) {
			for(int j=i; j<max; j++) {
				if(GiveClaim[i][j] && GiveClaim[j][i]) {
					GiveClaim[i][j] = true;
					GiveClaim[j][i] = false;
					Giver[i][j] = false;
				} else {
					GiveClaim[i][j] = false;
					GiveClaim[j][i] = false;
				}
				//System.out.print(" "+((Give[i][j])? 1 : 0)+" ");
			}
			//System.out.println();
		}

		int lostTickets = 0;
		int[] lastHoldTicket = new int[n];
		for(int i=0; i<n; i++) {
			lastHoldTicket[i] = findLastHoldTicket(GiveClaim, i, max);
			//System.out.println(" "+lastHoldTicket[i]);
			if(isTicketGiver(Giver, lastHoldTicket[i], max))
				lostTickets++;
		}
		return lostTickets;

	}

	public static boolean isTicketGiver(boolean[][] Giver, int i, int max)
	{
		for(int j=0; j<max; j++) {
			if(Giver[i][j])
				return true;
		}
		return false;
	}

	public static int findLastHoldTicket(boolean[][] GiveClaim, int i, int max)
	{
		for(int j=0; j<max; j++) {
			if(GiveClaim[i][j])
				return findLastHoldTicket(GiveClaim, j, max);
		}
		return i;
	}

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		int t = Integer.parseInt(input.nextLine());


		for(int i=0; i<t; i++)
			System.out.println(reportLostTickets(input));
	}

}