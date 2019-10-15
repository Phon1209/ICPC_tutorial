#include<bits/stdc++.h>
using namespace std;
// Maxsum 1D
/*
an efficient algorithm to find the sum of contiguous subarray within
a one-dimensional array of numbers which has the largest sum.
*/
#define MAX_N 100005  // varies by type of problem
int arr[MAX_N];

int main()
{
    int size;
    scanf("%d",&size);
    for(int i=0;i<size;i++)
    {
        scanf("%d",&arr[i]);
    }

    int maxEndedHere = 0;
    int maxAnswer = 0;// change 0 to INT_MIN if it must contain at least one number
    for(int i=0;i<size;i++)
    {
        maxEndedHere += arr[i];
        maxAnswer = max(maxAnswer,maxEndedHere);
        maxEndedHere = max(0,maxEndedHere);
    }
    printf("Maximum contiguous sum is %d\n",maxAnswer);
}
