#include<bits/stdc++.h>
using namespace std;
// Quicksum 2D
/*
an efficient algorithm to find the sum of rectangle within
a two-dimensional array of numbers.
*/

#define MAX_N 1005
int input[MAX_N][MAX_N];
int quickSum[MAX_N][MAX_N];

int sumInRange(int x,int y,int x2,int y2) // used for compute the sum of rectangle [x,y,x2,y2]
{
    return quickSum[x2][y2]
           - quickSum[x2][y-1]
           - quickSum[x-1][y2]
           + quickSum[x-1][y-1];
}
void generateQuickSumArray()
{
    for(int i=1;i<=size;i++)
    {
        for(int j=1;j<=size;j++)
        {
            quickSum[i][j]= input[i][j]
                            + quickSum[i-1][j]
                            + quickSum[i][j-1]
                            - quickSum[i-1][j-1];
        }
    }
}
int main()
{
    int size;
    scanf("%d",&size);
    for(int i=1;i<=size;i++)
    {
        for(int j=1;j<=size;j++)
        {
            scanf("%d",&input[i][j]);
        }
    }
    generateQuickSumArray();

}
