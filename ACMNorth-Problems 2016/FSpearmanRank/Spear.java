import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Spear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//assumption is the pair is alway has the same size, no duplication
		//String ss = "56 75 45 71 62 64 58 80 76 61\n66 70 40 60 65 56 59 77 67 63\n5 4 3 2 1\n1 2 3 4 5";
		
		Scanner scan = new Scanner (System.in);

		while(scan.hasNext()) {
			String ss1[] = null, ss2[] = null;
			String s1 = null, s2 = null; 
			ArrayList<Spearstore> si1 = new ArrayList<Spearstore>();
			ArrayList<Spearstore> si2 = new ArrayList<Spearstore>();
			s1 = scan.nextLine();
			ss1 = s1.split(" ");
			s2 = scan.nextLine();
			ss2 = s2.split(" ");
			for (int i = 0; i<ss1.length; i++) {
				si1.add(new Spearstore(Integer.parseInt(ss1[i]), i+1));
				si2.add(new Spearstore(Integer.parseInt(ss2[i]), i+1));
				
			}
		//System.out.println(si1.get(0).data); 
		
		ArrayList<Spearstore> sb1 = new ArrayList<Spearstore>();
		sb1 = (ArrayList<Spearstore>) si1.clone();
		ArrayList<Spearstore> sb2 = new ArrayList<Spearstore>();
		sb2 = (ArrayList<Spearstore>) si2.clone();
		
		Collections.sort(si1, new Comparator<Spearstore>() {
	        @Override
	        public int compare(Spearstore s1, Spearstore s2)
	        {

	            return  s2.data.compareTo(s1.data); 
	        }
	    });
		Collections.sort(si2, new Comparator<Spearstore>() {
	        @Override
	        public int compare(Spearstore s1, Spearstore s2)
	        {

	            return  s2.data.compareTo(s1.data); 
	        }
	    });
		for(int i=0; i<si1.size(); i++) {
			si1.get(i).rank = i+1; 
			si2.get(i).rank = i+1;
		}
		
		//add rank
		for (int i=0;i<si1.size();i++) 
			for(int j=0; j<si1.size();j++) 
				if(sb1.get(i).data == si1.get(j).data) 
					sb1.get(i).rank = j+1; 
		
		for (int i=0;i<si2.size();i++) 
			for(int j=0; j<si2.size();j++) 
				if(sb2.get(i).data == si2.get(j).data) 
					sb2.get(i).rank = j+1; 
		
//		System.out.println("s1");
//		for(int i=0; i<sb1.size(); i++)
//			System.out.print(sb1.get(i).data + " "); 
//		System.out.println();
//		for(int i=0; i<si1.size(); i++)
//			System.out.print(si1.get(i).data + " "); 
//		System.out.println();
//		for(int i=0; i<sb1.size(); i++)
//			System.out.print(sb1.get(i).pos + " "); 
//		System.out.println();
//		for(int i=0; i<sb1.size(); i++)
//			System.out.print(sb1.get(i).rank + " "); 
//		System.out.println();
//		
//		//System.out.println(si2);
//		System.out.println("s2");
//		for(int i=0; i<sb2.size(); i++)
//			System.out.print(sb2.get(i).data + " "); 
//		System.out.println();
//		for(int i=0; i<si2.size(); i++)
//			System.out.print(si2.get(i).data + " "); 
//		System.out.println();
//		for(int i=0; i<sb2.size(); i++)
//			System.out.print(sb2.get(i).pos + " "); 
//		System.out.println();
//		for(int i=0; i<sb2.size(); i++)
//			System.out.print(sb2.get(i).rank + " "); 
//		System.out.println();		
		//diff ranking 
		int sumdsq = 0; 
		for(int i=0; i<sb1.size(); i++){
			//System.out.println((int) (sumdsq + Math.pow(sb1.get(i).rank - sb2.get(i).rank, 2)));
			sumdsq = (int) (sumdsq + Math.pow(sb1.get(i).rank - sb2.get(i).rank, 2));
		}
		//System.out.println(sumdsq);
		double result = 0.0;
		result = (1-6*sumdsq/(sb1.size()*(Math.pow(sb1.size(), 2)-1)));
		if (Math.signum(result)==0.0)
			System.out.println("Neutral");
		else if (Math.signum(result)>0.0)
			System.out.println("Positive");
		else 
			System.out.println("Negative");
	

	}
	}

}
class Spearstore {
	public Integer data;
	public Integer pos;
	public Integer rank;
	public Spearstore(int d, int p) {
		// TODO Auto-generated constructor stub
		data = d; 
		pos = p;
		rank = 0;
	}
}
