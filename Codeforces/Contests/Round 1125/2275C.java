import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void solve(FastScanner in, FastPrinter out) throws IOException {
        int n = in.nextInt();
        int[] arr = new int[n];
        long res = 0;
        int[] sums = new int[n-4];

        // Input
        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        // Logic
        for (int i=0; i<n-4; i++){
            int sum = arr[i] + arr[i+2] - arr[i+4];
            sums[i] = sum;
        }

        // Get the most common sum
        int max_occ_sum = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n-4; i++){
            int curr = sums[i];
            map.put(curr, map.getOrDefault(curr, 0)+1);
            if (curr!=max_occ_sum){
                if (map.get(max_occ_sum)==null || map.get(curr)>map.get(max_occ_sum)) max_occ_sum = curr;
            }
        }

        // Count pairs
        int[] even = new int[n-4];
        int[] odd = new int[n-4];
        int ec = 0, oc = 0;
        for (int i=n-5; i>=0; i--){
            even[i] = ec;
            odd[i] = oc;
            if (sums[i]==max_occ_sum){
                if (i%2==0) ec++;
                else oc++;
            }
        }

        for (int i=0; i<n-4; i++){
            if (sums[i]==max_occ_sum){
                if (i%2==0){
                    res += odd[i];
                    if (i+4<n-4) res += even[i+4];
                }else{
                    res += even[i];
                    if (i+4<n-4) res += odd[i+4];
                }
            }
        }
        out.println(res);
    }

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner(System.in);
        FastPrinter out = new FastPrinter(System.out);

        int t = 1;
        t = in.nextInt(); // Comment this line if the problem doesn't have multiple test cases

        while (t-- > 0) {
            solve(in, out);
        }

        out.flush();
    }

    // High-speed Byte Reader
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16]; // 64KB Buffer
        private int head = 0, tail = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = in.read(buffer, 0, buffer.length);
                } catch (IOException e) {
                    return -1;
                }
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return 0;
                c = read();
            }
            int sgn = 1;
            if (c == '-') { sgn = -1; c = read(); }
            int res = 0;
            do {
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return 0;
                c = read();
            }
            int sgn = 1;
            if (c == '-') { sgn = -1; c = read(); }
            long res = 0;
            do {
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (c <= ' ') c = read();
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

    // High-speed Byte Writer (Outperforms PrintWriter)
    static class FastPrinter {
        private final OutputStream out;
        private final byte[] buffer = new byte[1 << 16]; // 64KB Buffer
        private int head = 0;

        public FastPrinter(OutputStream out) {
            this.out = out;
        }

        public void print(byte b) throws IOException {
            if (head >= buffer.length) flush();
            buffer[head++] = b;
        }

        public void print(int n) throws IOException {
            if (n == 0) { print((byte) '0'); return; }
            if (n < 0) { print((byte) '-'); n = -n; }
            int temp = n, digits = 0;
            while (temp > 0) { digits++; temp /= 10; }
            if (head + digits >= buffer.length) flush();
            head += digits;
            int idx = head - 1;
            while (n > 0) {
                buffer[idx--] = (byte) ('0' + (n % 10));
                n /= 10;
            }
        }

        public void print(long n) throws IOException {
            if (n == 0) { print((byte) '0'); return; }
            if (n < 0) { print((byte) '-'); n = -n; }
            long temp = n; int digits = 0;
            while (temp > 0) { digits++; temp /= 10; }
            if (head + digits >= buffer.length) flush();
            head += digits;
            int idx = head - 1;
            while (n > 0) {
                buffer[idx--] = (byte) ('0' + (n % 10));
                n /= 10;
            }
        }

        public void print(String s) throws IOException {
            for (int i = 0; i < s.length(); i++) {
                print((byte) s.charAt(i));
            }
        }

        public void println() throws IOException { print((byte) '\n'); }
        public void println(int n) throws IOException { print(n); println(); }
        public void println(long n) throws IOException { print(n); println(); }
        public void println(String s) throws IOException { print(s); println(); }

        public void flush() throws IOException {
            if (head > 0) {
                out.write(buffer, 0, head);
                head = 0;
            }
        }
    }
}