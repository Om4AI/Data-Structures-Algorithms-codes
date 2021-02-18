hrs=int(input(""))
mins=int(input(""))

tens={
10:"ten",11:"eleven",12:"twelve",13:"thirteen",14:"forteen",16:"sixteen",17:"seventeen",18:"eighteen",19:"nineteen",
15:"quarter",
20:"twenty",
30:"half",
}

nums={
1:"one",2:"two",3:"three",4:"four",5:"five",6:"six",7:"seven",8:"eight",9:"nine",10:"ten",11:"eleven",12:"twelve"
}

if (mins==00):
    c=nums[hrs]
    print(c+" o' clock" )

elif ((mins<30) or (mins==30)):
    if (mins==15):
        c=nums[hrs]
        print("quarter past "+c)
    elif (mins==30):
        c=nums[hrs]
        print("half past "+c)
    elif (mins<10):
        a=nums[mins]
        c=nums[hrs]
        if (a=="one"):
            print(a+" minute past "+c)
        else:
            print(a+" minutes past "+c)
    elif (mins>10 and mins<20):
        a=tens[mins]
        c=nums[hrs]
        print(a+" minutes past "+c)
    else:
        r=mins%10
        mins=mins-r
        a=tens[mins]
        b=nums[r]
        c=nums[hrs]
        print(a+" "+b+" minutes past "+c)


elif (mins>30):
    mins=60-mins
    if (mins==15):
        c=nums[hrs+1]
        print("quarter to "+c)
    elif (mins<10):
        a=nums[mins]
        c=nums[hrs+1]
        if (a=="one"):
            print(a+" minute to "+c)
        else:
            print(a+" minutes to "+c)
    elif ((mins>10 or mins==10) and (mins<20 or mins==20)):
        a=tens[mins]
        c=nums[hrs+1]
        print(a+" minutes to "+c)
    else:
        r=mins%10
        mins=mins-r
        a=tens[mins]
        b=nums[r]
        c=nums[hrs+1]
        print(a+" "+b+" minutes to "+c)
