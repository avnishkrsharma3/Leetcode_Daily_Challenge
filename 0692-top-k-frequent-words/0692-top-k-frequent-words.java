class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> tmap = new TreeMap<>(Collections.reverseOrder());
        for(String word : words){
            tmap.put(word, tmap.getOrDefault(word, 0) + 1);
        }
        Pair[] arr = new Pair[tmap.size()];
        int i = 0;
        for(Map.Entry<String, Integer> iter: tmap.entrySet()){
            Pair p = new Pair(iter.getValue(), iter.getKey());
            arr[i++] = p;
        }
        Arrays.sort(arr, (Pair p1, Pair p2) -> {
            if(p1.cnt < p2.cnt){
                return 1;
            }
            else if(p1.cnt == p2.cnt){
                return (p1.str).compareTo(p2.str);
            }
            else 
                return -1;
        });
        List<String> retList = new ArrayList<>();
        for(int j = 0;  j < k; j++){
            Pair p = arr[j];
            retList.add(p.str);
        }
        return retList;
    }
    class Pair{
        private int cnt;
        private String str;
        Pair(int cnt, String str){
            this.cnt = cnt;
            this.str = str;
        }
    }
}