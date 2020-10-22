#include <iostream>

using namespace std;

class Rectangle
{
    protected:
    int width,height;
    public:
    int display()
    {
        cout<<width<<" "<<height;
        return 0;
    }
};
class RectangleArea:public Rectangle
{
    public:
        int area;
    int read_input()
    {
        cin>>width>>height;
        return 0;
    }
    int display()
    {
        area=width*height;
        cout<<endl<<area;
        return area;
    }
};

int main()
{
    /*
     * Declare a RectangleArea object
     */
    RectangleArea r_area;
    
    /*
     * Read the width and height
     */
    r_area.read_input();
    
    /*
     * Print the width and height
     */
    r_area.Rectangle::display();
    
    /*
     * Print the area
     */
    r_area.display();
    
    return 0;
}
