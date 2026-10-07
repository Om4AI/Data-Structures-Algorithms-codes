import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Main {
    // Range of V(i) is [-30000, 30000], so array size of 60005 with OFFSET = 30000 is safe
    private static final int OFFSET = 30000;
    private static final int MAX_RANGE = 60005;
    private static final int[] freq = new int[MAX_RANGE];

    public static void solve(FastScanner in, FastPrinter out) throws IOException {
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int m = n - 4; // Total number of triads
        int[] sums = new int[m];
        for (int i = 0; i < m; i++) {
            sums[i] = arr[i] + arr[i + 2] - arr[i + 4];
        }

        long res = 0;

        for (int i = 0; i < m; i++) {
            // Add triad sum from 5 indices behind into the frequency array
            if (i >= 5) {
                freq[sums[i - 5] + OFFSET]++;
            }

            // Count disjoint pairs where index j <= i - 5
            res += freq[sums[i] + OFFSET];

            // Count adjacent index (i - 1), which is also disjoint
            if (i >= 1 && sums[i - 1] == sums[i]) {
                res++;
            }
        }

        // Clean up frequency array for the next testcase
        for (int i = 0; i < m; i++) {
            if (i >= 5) {
                freq[sums[i - 5] + OFFSET]--;
            }
        }

        out.println(res);
    }

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner(System.in);
        FastPrinter out = new FastPrinter(System.out);

        int t = in.nextInt();

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
    }

    // High-speed Byte Writer
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

        public void println() throws IOException { print((byte) '\n'); }
        public void println(int n) throws IOException { print(n); println(); }
        public void println(long n) throws IOException { print(n); println(); }

        public void flush() throws IOException {
            if (head > 0) {
                out.write(buffer, 0, head);
                head = 0;
            }
        }
    }
}