#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;

int main(){
   /* ifstream inFile("ex1_input.txt", ios::in);
    if(!inFile){
        cerr << "File could not be opened." << endl;
        //cout << std::system("pwd");
        return 1;
    }
    */
    unsigned long int num, diff, rows, cols, r, c, num_direct[4], r_direct[4], c_direct[4], g_direct[4], g, elem, tmp;
    
    int i;
	int T;
	cin >> T;
    while((T--)!=0){
		cin >> num >> diff >> rows >> cols;
        tmp = (num-1)/diff;
        g = tmp/cols;
        elem = tmp - g*cols;
        
        
        tmp = ceil(cols/2.0);
        if(elem < tmp)
            r = g*2;
        else
            r = g*2 + 1;
        
        if(r%2 == 0)
            c = elem*2;
        else
            c = (elem - tmp)*2 + 1;
        
        
        for(i=0; i<4; i++) num_direct[i] = 1;
        
        if(r == 0)
            num_direct[0] = num_direct[1] = 0;
        else if(r == rows-1)
            num_direct[2] = num_direct[3] = 0;
        
        if(c == 0)
            num_direct[0] = num_direct[2] = 0;
        else if(c == cols-1)
            num_direct[1] = num_direct[3] = 0;
        
        if(r%2 == 0){
            if(r > 0)
                g_direct[0] = g_direct[1] = g-1;
            g_direct[2] = g_direct[3] = g;
        }else{
            g_direct[0] = g_direct[1] = g;
            if(r < rows-1)
                g_direct[2] = g_direct[3] = g+1;
        }
        
        
        for(i=0; i<4; i++){
            if(num_direct[i] != 0){
                switch(i){
                    case 0:
                        r_direct[i] = r-1; c_direct[i] = c-1;
                        break;
                    case 1:
                        r_direct[i] = r-1; c_direct[i] = c+1;
                        break;
                    case 2:
                        r_direct[i] = r+1; c_direct[i] = c-1;
                        break;
                    case 3:
                        r_direct[i] = r+1; c_direct[i] = c+1;
                        break;
                }
            }
        }
        
        for(i=0; i<4; i++){
            if(num_direct[i] != 0){
                if(r_direct[i]%2 == 0)
                    elem = c_direct[i]/2;
                else
                    elem = (unsigned long int)ceil(cols/2.0) + (c_direct[i]-1)/2;
                
                num_direct[i] = 1 + diff*(g_direct[i]*cols + elem);
            }
            num_direct[i] == 0 ? cout << -1 << endl: cout << num_direct[i] << endl;
        }
        //cout << endl;
        
    } // while

    //inFile.close();
    
    return 0;
}
