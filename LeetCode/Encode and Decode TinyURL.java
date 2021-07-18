// Code by @Om 
// Solution using ASCII value concept

public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuffer start = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        int i;
        // To be encoded
        for (i=longUrl.length()-1; i>=0; i--){
            if (longUrl.charAt(i)=='/') break;
            else sb.append(longUrl.charAt(i));
        }
        // Starting url
        for (int k=0; k<=i; k++){
            start.append(longUrl.charAt(k));
        }
        sb.reverse();

        // Encoding
        StringBuffer to_append = new StringBuffer();
        for (int j=0; j<sb.length(); j++){
            to_append.append((int)sb.charAt(j)+",");
        }
        start.append(to_append);
        return start.toString();
    }


    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl){
        StringBuffer start = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        int i;
        for (i=shortUrl.length()-1; i>=0; i--){
            if (shortUrl.charAt(i)=='/') break;
            else sb.append(shortUrl.charAt(i));
        }
        // Starting url
        for (int k=0; k<=i; k++){
            start.append(shortUrl.charAt(k));
        }
        sb.reverse();
        String s[] = sb.toString().split(",");
        StringBuffer to_append = new StringBuffer();
        // Decode
        for (int k=0; k<s.length; k++){
            if (s[k].equals("")==false){
                int t = Integer.valueOf(s[k]);
                to_append.append((char)t);
            }
            
        }
        start.append(to_append);
        return start.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
