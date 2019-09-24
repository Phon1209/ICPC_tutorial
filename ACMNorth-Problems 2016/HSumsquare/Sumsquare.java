import java.util.Scanner;

public class Sumsquare {
	public static void findMaxSubMatrix(int[][] a) {
        int cols = a[0].length;
        int rows = a.length;
        int[] currentResult;
        int maxSum = -127*100*100;
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        for (int leftCol = 0; leftCol < cols; leftCol++) {
            int[] tmp = new int[rows];
     
            for (int rightCol = leftCol; rightCol < cols; rightCol++) {
         
                for (int i = 0; i < rows; i++) {
                    tmp[i] += a[i][rightCol];
                }
                currentResult = memmo(tmp);
                if (currentResult[0] > maxSum) {
                    maxSum = currentResult[0];
                    left = leftCol;
                    top = currentResult[1];
                    right = rightCol;
                    bottom = currentResult[2];
                }
            }
        }
             
              System.out.println(maxSum + " (" + top + ", " + left + ") ("+ top + ", " + right + ") (" + bottom + ", " + left + ") (" + bottom + ", " + right + ")");
    }
	  public static int[] memmo(int[] a) {
	        //result[0] == maxSum, result[1] == start, result[2] == end;
	        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
	        int currentSum = 0;
	        int localStart = 0;
	     
	        for (int i = 0; i < a.length; i++) {
	            currentSum += a[i];
	            if (currentSum < 0) {
	                currentSum = 0;
	                localStart = i + 1;
	            } else if (currentSum > result[0]) {
	                result[0] = currentSum;
	                result[1] = localStart;
	                result[2] = i;
	            }
	        }
	         
	        //all numbers in a are negative
	        if (result[2] == -1) {
	            result[0] = -127*100*100;
	            for (int i = 0; i < a.length; i++) {
	                
	            	if (a[i] > result[0]) {
	                    result[0] = a[i];
	                    result[1] = i;
	                    result[2] = i;
	                }
	            }
	        }
	         
	        return result;
	    }
	

	public static void main(String[] args)throws java.lang.Exception
	{
		int aa[][]=new int[100][100];
		//System.out.println("Input t:");
		Scanner scan = new Scanner(System.in);
		int t,n;
		//final long startTime = System.currentTimeMillis();
		t=scan.nextInt();
		
		int i,j,k;
		for(k=0;k<t;k++){
			//System.out.println("Input n:");
			n=scan.nextInt();
			scan.nextLine();
			for (i = 0; i < n; i++) {
				String[] line = scan.nextLine().split(" ");
				for (j = 0; j < n; j++) {
					aa[i][j] = Integer.parseInt(line[j]);

				}
			}
		//*********************Code for dynamic Programming
		int b[][]=new int[n][n];
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				b[i][j]=aa[i][j];
			}
		}
		
		
		findMaxSubMatrix(b);
		
		}
		//*********************
		//final long endTime = System.currentTimeMillis();
		//System.out.println("Total execution time: " + (endTime-startTime) + "mil.sec" );
	}

}
