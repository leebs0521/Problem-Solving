#include <iostream>
#include <list>
using namespace std;
 
int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
 
	string s;
	char op;
	int M;
	cin >> s >> M;
	list<char> l(s.begin(), s.end());
	list<char>::iterator t = l.end();
	// auto t = l.end();
 
	for (int i = 0; i < M; i++) {
		cin >> op;
		if (op == 'L' && t != l.begin()) t--;
		else if (op == 'D' && t != l.end()) t++;
		else if (op == 'B' && t != l.begin()) t = l.erase(--t);
		else if (op == 'P') {
			cin >> op;
			l.insert(t, op);
		}
	}
	for (t = l.begin(); t != l.end(); t++) cout << *t;
	// for (auto c : l) cout << c;
 
	return 0;
}