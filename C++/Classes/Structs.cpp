#include<iostream>
#include<cmath>
#include<vector>

using namespace std;


struct student
{
    int age;
    string first_name;
    string last_name;
    int std;
};

int main(){
    student s;
    cin>>s.age>>s.first_name>>s.last_name>>s.std;
    cout<<s.age<<" "<<s.first_name<<" "<<s.last_name<<" "<<s.std;
}
