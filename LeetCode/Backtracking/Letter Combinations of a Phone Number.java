// Code by Om

class Solution {
    public List<String> letterCombinations(String digits) {
        int k = digits.length();
        if(k==0) return new ArrayList<String>();
        List<List<String>> res = new ArrayList();
        
//         Create a HashMap for getting the elements
        HashMap<Character, List<String>> map = new HashMap<>();
        
//         Create lists
        List<String> two = new ArrayList<>();
        Collections.addAll(two, "a","b","c");
        List<String> three = new ArrayList<>();
        Collections.addAll(three, "d","e","f");
        List<String> four = new ArrayList<>();
        Collections.addAll(four, "g","h","i");
        List<String> five = new ArrayList<>();
        Collections.addAll(five, "j","k","l");
        List<String> six = new ArrayList<>();
        Collections.addAll(six, "m","n","o");
        List<String> seven = new ArrayList<>();
        Collections.addAll(seven, "p","q","r","s");
        List<String> eight = new ArrayList<>();
        Collections.addAll(eight, "t","u","v");
        List<String> nine = new ArrayList<>();
        Collections.addAll(nine, "w","x","y","z");
        
//         Add lists to map
        map.put('2', two);
        map.put('3', three);
        map.put('4', four);
        map.put('5', five);
        map.put('6', six);
        map.put('7', seven);
        map.put('8', eight);
        map.put('9', nine);
    
        List<String> arr = new ArrayList<>();
        for(int i=0; i<digits.length(); i++) arr.addAll(map.get(digits.charAt(i)));
        
        
//         Call the backtrack function
        backtrack(arr,k,0,res,new ArrayList<>());
//         res - has all the pairs as lists
        
        
        List<String> result = new ArrayList<>();
//         Check for proper pairs
        for(int i=0; i<res.size(); i++){
            int f = 1;
            for(int j=0; j<k; j++){
                String s = res.get(i).get(j);
                char key = digits.charAt(j);
                if(!map.get(key).contains(s)){
                    f=0;
                    break;
                }
            }
            if(f==1){
                StringBuffer sb = new StringBuffer();
                for (String str:res.get(i)) sb.append(str);
                result.add(sb.toString());
            }
        }
        
        HashSet<String> set = new HashSet(result);
        List<String> res_final = new ArrayList(set);
        return res_final;
    }
    
    public void backtrack(List<String> arr,int k,int index,List<List<String>> res,ArrayList<String> list){
        if(list.size()==k) res.add(new ArrayList<>(list));
        
        for(int i=index; i<arr.size(); i++){
            list.add(arr.get(i));
            backtrack(arr,k,i+1,res,list);
            list.remove(list.size()-1);
        }
    }
}
