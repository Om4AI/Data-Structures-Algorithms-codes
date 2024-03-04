import java.math.BigInteger;

// Important datatype
public class Solution {
    public String solve(int A){
        BigInteger res = new BigInteger("1");

        for (int i=2; i<=A; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res.toString();
    }
}
