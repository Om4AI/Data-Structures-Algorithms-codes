class BusBooking {
    int[][] seats;
    int[][] times;
    int booked, totalTime;
    public BusBooking(int n) {
        seats = new int[n][4];
        times = new int[n][4];
        booked = 0;
        totalTime = 0;
    }

    public void toggle(String seat) {
        int l = seat.charAt(0) - 'A';
        int r = Integer.valueOf(seat.substring(1,seat.length()));
        // Booking
        // Window seat A
        if (seats[r][l]==0){
            // Booking now & checking adjacent
            if (l==0){ // A
                if (seats[r][l+1]==1){
                    totalTime += 3;
                    times[r][l] = 3;
                }else{
                    totalTime += 1;
                    times[r][l] = 1;
                }
            }else if (l==3){ // D
                if (seats[r][l-1]==1){
                    totalTime += 3;
                    times[r][l] = 3;
                }else{
                    totalTime += 1;
                    times[r][l] = 1;
                }
            }else{ // B & C
                totalTime++;
                times[r][l] = 1;
            }
            seats[r][l] = 1;
            booked++;
        }

        // Unbooking
        else if (seats[r][l]==1){
            seats[r][l] = 0;
            booked--;
            totalTime-=times[r][l];
        }
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getMinTime() {
        return booked;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */