#include <vector>
#include <iostream>


using namespace std;
vector<bool> v;
vector<vector<int> > primeFactors;
vector<bool> bPrime(10000000,true);

void sieveErstn(int n){

	bPrime[0]= false;
	bPrime[1]= false;
	primeFactors.reserve(n+1);

	for(int i=2;i<=n;i++){
    	if(bPrime[i]){
        	primeFactors[i].push_back(i);
        	for(int j=2*i;j<=n;j+=i){
            	bPrime[j]=false;
            	primeFactors[j].push_back(i);
        	} 
    	}
  	}
}
void findPrimacity(int a,int b,int k,int no){

    int cnt_P = 0;
    for(int i = a ;i <= b ;i++){
        if(primeFactors[i].size() == k){ cnt_P++;} 
    }
    cout<<"Case #"<<no <<": "<<cnt_P<<endl;
}

int main(int argc,char** argv){

  int no;
  cin >> no;
  int i = 0;
  int a,b,k;
  sieveErstn(10000000);
  while( i < no){
    cin >> a; cin >> b; cin >> k;
    i++;
    findPrimacity(a,b,k,i); 
  } 
}																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										