# <span style="color:cyan">Prelude to Competitive Programming

#### <span style="color:lightgreen">โปรแกรมที่ใช้เขียน</span>
- Code Block
- Dev-C

#### <span style="color:lightgreen">ตัวอย่างหน้าตาของโปรแกรม C/C++</span>
![Sample Code](http://4.bp.blogspot.com/-sOIp_D1YFGU/UtSTJc4N0iI/AAAAAAAAAJM/yL7jgzL6faU/s640/linear_search_or_sequential_search_example_code_cpp.GIF)

![](https://1.bp.blogspot.com/-SV69oGuD_ns/Uf64nynoggI/AAAAAAAAAoo/Emv3UI0rT_U/s1600/swap-funtion-cpp-example.PNG)

###### <span style="color:yellow">Header
- include< HEADER >
- define name val
    - #define VAT 0.07
    - #define day_in_year 365
- Function


###### <span style="color:yellow">Body
- int main()
    - โปรแกรมจะเริ่มทำงานที่นี่

#### <span style="color:lightgreen">Type of Data

- Integer
    - int (4 byte) <span style="color:lightblue"> เก็บค่าได้ตั้งแต่ -2^31 จนถึง 2^31-1
    - long long (8 byte)<span style="color:lightblue"> เก็บค่าได้ตั้งแต่ -2^63 จนถึง 2^63-1
- Floating point
    - double (8 byte)<span style="color:lightblue"> เก็บค่าได้ 1.7E +/- 308
- Character

#### <span style="color:lightgreen">คำสั่งพื้นฐาน

- printf("```สิ่งที่จะแสดง```");
    - Escape Character
        - `\n` ขึ้นบรรทัดใหม่
        - `\t` tab
        - `\\` พิมพ์ `\`
        - `\'` พิมพ์ `'`
        - `\"` พิมพ์ `"`
-




```cpp
vector<pair<int,int> > v[10005];

int D[1005][1005]

vector<pair<pair<int,int> ,int> > e;

int main()
{
	while(m--)
	{
		sint3(x,y,w);
		v[x].push_back(make_pair(y,w));
		v[y].push_back(make_pair(x,w));


		D[x][y]=w;
		D[y][x]=w;

		e.push_back(make_pair(make_pair(x,y),w));
		e.push_back(make_pair(make_pair(y,x),w));
	}
}
```
```cpp
vector<int> v[2005];
int visit[1005];
bool dfs(int t,int u)
{
	visit[t]=1;
	bool found = false;
	for(int i=0;i<v[t].size();i++)
	{
		int y=v[t][i];
		if(y==u)return true;
		if(visit[y]==true)continue;
		if(dfs(y,u)==true)found=true;
	}
	return found;
}

```
