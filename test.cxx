#include<bits/stdc++.h>
using namespace std;
vector <int> v[1005];
bool found;
int visit[1005];
main()
{
	int n,m,q,s,e,t,u;
	scanf("%d %d %d",&n,&m,&q);
	for(int i=0;i<m;i++)
	{
		scanf("%d %d",&s,&e);
		v[s].push_back(e);
	}
	while (q--)
	{
		scanf("%d %d",&t,&u);
		memset(visit,0,sizeof(visit));
		found=false;
		queue<int> Q;
		Q.push(t);
		visit[t]=1;
		while(!Q.empty())
		{
			int x =Q.front();
			Q.pop();
			for(int i=0;i<v[x].size();i++)
			{
				int y=v[x][i];
				if(visit[y])continue;
				visit[y]=1;
				Q.push(y);
				if(y==u) {
					found= true;
					break;
				}
			}
			if(found) break;
		}
		printf("%s\n",(found)? "Yes":"No");
	}
}
/*
5 5 3
1 2
2 3
1 4
4 5
3 4
3 5
1 3
3 1

*/
