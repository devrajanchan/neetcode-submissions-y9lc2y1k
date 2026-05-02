public class TimeMap {
    class data{
        int timestamp;
        String value;
        data(int timestamp, String value){
            this.timestamp=timestamp;
            this.value=value;
        }
    }
    private Map<String, List<data> >m;

    public TimeMap() {
        m = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key, k -> new ArrayList<>()).add(new data(timestamp,value));
    }

    public String get(String key, int timestamp) {
        if(!m.containsKey(key)) return "";
        return binarySearch(m.get(key),timestamp);
         
    }
    public String binarySearch(List<data> list,int timestamp)
    {
        int low=0;
        int high =list.size()-1;
        String res="";
        while(low<=high)
        {
            int mid= low + (high- low)/2;
            if(list.get(mid).timestamp<=timestamp)
            {
                res=list.get(mid).value;
                low=mid+1;
            }
            else high=mid-1;
        }
        return res;
    }
}

