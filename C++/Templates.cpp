#include <iostream>
using namespace std;

template<class T>
    void ascending_order(T arr[],int n){
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if (arr[i]>arr[j]){
                    T t;
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

template<class T>
    void display_data(T arr[], int n){
        // Print
        cout<<endl;
        for (int i=0; i<n; i++){
            cout<<arr[i]<<" ";
        }
        cout<<endl;
}

int main(){
    int n = 6;
    float float_data[n] = { 0.0, 10.56, 28.46, 17.4, -91.7, 113.18 };
    ascending_order(float_data, n);
    display_data(float_data, n);


    string names[n] = {"NAGARAJA", "NIKHIL", "AAKASH", "ANAND" , "RAMESH", "HRIDAYA"};
    ascending_order(names, n);
    display_data(names, n);

    int integer_data[n] = { 50, 20, 45, -10, 11, 0 };
    ascending_order(integer_data, n);
    display_data(integer_data, n);
    return 0;
}

