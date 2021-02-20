

template<class T>
class AddElements
{
    public:
    T a;
    T b;
    AddElements(T x)
    {
        a=x;
    }

    T add(T y)
    {
        T c;
        c=a+y;
        return c;
    }

    T concatenate(T y)
    {
        T c;
        c=a+y;
        return c;
    }
};
