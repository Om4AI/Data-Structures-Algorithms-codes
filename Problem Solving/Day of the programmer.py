import calendar

def julian_leap(y):
    if (y%4==0):
        return True
    else:return False

y=int(input())
if (y>1699 and y<1918):
    if (julian_leap(y)==True):
        print('12.09.'+str(y))
    else:print('13.09.'+str(y))
elif (y==1918):
    print('26.09.1918')
elif (y>1918 and y<2701):
    if (calendar.isleap(y)):
        print('12.09.'+str(y))
    else:print('13.09.'+str(y))
