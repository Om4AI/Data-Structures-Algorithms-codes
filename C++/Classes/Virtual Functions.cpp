#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Person
{
public:
    int age;
    string name;
public:
    virtual void getdata() {
        cin >> this->name >> this->age;
    }
    virtual void putdata() {
        cout << this->name << " " << this->age << endl;
    }
};

// Professor Class
class Professor: public Person
{
private:
    int publications,cur_id;
    static int id;
public:
    Professor()
    {
        cur_id=++id;
    }
    void getdata();
    void putdata()
    {
        cout<<name<<" "<<age<<" "<<publications<<" "<<cur_id<<endl;
    }
};

void Professor::getdata()
{
    cin>>name>>age>>publications;
}
int Professor::id = 0;


// Student Class
class Student:public Person
{
private:
    int marks[6],sum=0;
    static int id;
    int cur_id;
public:
    Student()
    {
        cur_id=++id;
    }
    void getdata()
    {
        cin>>name>>age;
        int j;
        for (j=0;j<6;j++)
        {
            cin>>marks[j];
            sum+=marks[j];
        }
    }
    void putdata()
    {
        cout<<name<<" "<<age<<" "<<sum<<" "<<cur_id<<endl;
    }
};
int Student::id = 0;

int main(){

    int n, val;
    cin>>n; //The number of objects that is going to be created.
    Person *per[n];

    for(int i = 0;i < n;i++){

        cin>>val;
        if(val == 1){
            // If val is 1 current object is of type Professor
            per[i] = new Professor;

        }
        else per[i] = new Student; // Else the current object is of type Student

        per[i]->getdata(); // Get the data from the user.

    }

    for(int i=0;i<n;i++)
        per[i]->putdata(); // Print the required output for each object.

    return 0;

}
