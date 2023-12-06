class Solution {
    public int totalMoney(int n) {
        int monday = 1, total = 0;
        int weeks = n/7, days = n%7;

        while (weeks>0){
            int last_day = monday + 6;
            total += (((monday+last_day)*7)/2);

            weeks--;
            monday++;
        }

        int last_day = monday+days-1;
        total += (((monday+last_day)*days)/2);
        return total;
    }
}