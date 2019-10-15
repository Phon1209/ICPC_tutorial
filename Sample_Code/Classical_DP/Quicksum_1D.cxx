#include<bits/stdc++.h>
using namespace std;
//Quicksum 1D
/*
an efficient algorithm to find the sum of contiguous subarray within
a one-dimensional array of numbers.
*/

#define MAX_N 100005
int input[MAX_N];
int quickSum[MAX_N];

int sumInRange(int x,int y) // used for compute the sum of subbarray in range [x,y]
{
    if(x==0)return quickSum[y];
    return quickSum[y]-quickSum[x-1];
}
void generateQuickSumArray()
{
    for(int i=0;i<size;i++)
    {
        if(i==0)quickSum[i]=input[i];
        else quickSum[i]=quickSum[i-1]+input[i];
    }
}
int main()
{
    int size;
    scanf("%d",&size);
    for(int i=0;i<size;i++)
    {
        scanf("%d",&input[i]);
    }
    generateQuickSumArray();

}
