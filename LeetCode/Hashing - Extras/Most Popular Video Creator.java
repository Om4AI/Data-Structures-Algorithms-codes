import java.util.*;

class View{
    long count;
    String ID;
    int maxofcreator;
    View(long c, String s, int max){
        count = c;
        ID = s;
        maxofcreator = max;
    }
}

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views){
        List<List<String>> res = new ArrayList<>();
        HashMap<String,View> map = new HashMap<>();
        int n = creators.length;
        long max_views = 0;

        // Fill up the Hashmap with view count and ID of popular videos
        for(int i=0; i<n; i++){
            String name = creators[i];
            int vc = views[i];
            String tempid = ids[i];

            if(!map.containsKey(name)){
                View obj = new View(vc,tempid,vc);
                map.put(name, obj);
            }else{
                View obj = map.get(name);

                // Count the total views
                obj.count += vc;

                // Compare the IDs for lexicographical smallest (obj.ID & tempid)
                if(vc==obj.maxofcreator && tempid.compareTo(obj.ID)<0) obj.ID = tempid;

                // Update the values if video with more views is listed
                if(vc>obj.maxofcreator){
                    obj.ID = tempid;
                    obj.maxofcreator = vc;
                }
            }

            max_views = Math.max(max_views, map.get(name).count);
        }

        // Add the creators with max views in result
        for(String s: map.keySet()){
            if(map.get(s).count==max_views){
                List<String> l = new ArrayList<>();
                l.add(s);
                l.add(map.get(s).ID);
                res.add(l);
            }
        }
        return res;
    }
}