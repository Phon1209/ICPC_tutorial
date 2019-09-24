import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Permutation {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> elements) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        solution.add(new ArrayList<Integer>());
        for (int i = 0; i < elements.size(); i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> l : solution) {
                for (int j = 0; j < l.size()+1; j++) {
                    l.add(j, elements.get(i));
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            solution = new ArrayList<ArrayList<Integer>>(current);
        }
        return solution;
    }
}

class Combination {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        recursion(n, k, new ArrayList<Integer>(), solution);
        return solution;
    }
     
    public void recursion(int n, int k, ArrayList<Integer> partial, 
        ArrayList<ArrayList<Integer>> solution) {
        if(partial.size() == k && !solution.contains(partial)) {
            Collections.sort(partial);
            solution.add(partial);
        } else if(partial.size() > k) {
            return;
        } else {
            for(int i = n; i >= 1; --i) {
                ArrayList<Integer> partialSolution = new ArrayList<Integer>();
                partialSolution.addAll(partial);
                partialSolution.add(i);
                recursion(i-1, k, partialSolution, solution);
            }
        }
    }
}

public class LoadBalancing {

	public static boolean isKColorable(int k, int n, int[] eu, int[] ev)
	{

		int r = (n-k)*k;
		int[] S = new int [r];
		for(int i=0; i<k; i++)
			for(int j=0; j<(n-k); j++)
				S[(i*(n-k))+j] = i+1;

		Combination COM = new Combination();
		ArrayList<ArrayList<Integer>> C = COM.combine(r, n-k);
		for(int j = 0; j < C.size(); j++) {
			ArrayList<Integer> c = C.get(j);

			ArrayList<Integer> vertex_color = new ArrayList<Integer>();
			for(int i=1; i<=k; i++)
				vertex_color.add(i);

			for(int l=0; l<c.size(); l++) {
				vertex_color.add(S[c.get(l)-1]);
			}

			Permutation PER = new Permutation();
			ArrayList<ArrayList<Integer>> P = PER.permute(vertex_color);	
			for(int l = 0; l < P.size(); l++) {
				ArrayList<Integer> per = P.get(l);

				Integer[] coloring = new Integer[per.size()];
				coloring = per.toArray(coloring);

				// for (int y=0; y<n; y++)
				// 	System.out.print(coloring[y]+" ");
				// System.out.println();

				boolean ret = true;
				int p = eu.length;
				for (int y=0; y<p; y++) {
					if(coloring[eu[y]] == coloring[ev[y]])
						ret = ret & false;
					else
						ret = ret & true;

					if((y==p-1) && ret)
						return true;
				}
				
			}
			
		}
		return false;
	}

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);

		for(int t=0; t<2; t++) {

			int n = input.nextInt();
			int p = input.nextInt();

			int[] eu = new int[p];
			int[] ev = new int[p];
			
			for(int i=0; i<p; i++) {
				eu[i] = input.nextInt()-1;
				ev[i] = input.nextInt()-1;
			}

			for(int k=1; k<=n; k++) {
				if(isKColorable(k, n, eu, ev)) {
					System.out.print(k+" ");
					break;
				}
			}
		}

	}

}