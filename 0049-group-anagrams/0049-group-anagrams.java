class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Pair[] copy = new Pair[strs.length];
        for(int i = 0; i < strs.length; i++){
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);
            // StringBuilder sb = new StringBuilder();
            // for(int j  = 0; j < ch.length; j++){
            //     sb.append(ch[j]);
            // }
            String st = String.valueOf(ch);
            Pair p = new Pair(st, i);
            copy[i] = p;
        }
        Arrays.sort( copy, (p1, p2) -> {
            return p1.str.compareTo(p2.str);
        } );
        
        List<List<String>> ansList =  new ArrayList<>();
        
         for(int i = 0; i < copy.length; i++){
           // System.out.println(copy[i].str + " " + copy[i].idx);
             String str  = copy[i].str;
             List<String> list = new ArrayList<>();
             while(i < copy.length && (copy[i].str).equals(str)){
                 list.add(strs[copy[i].idx]);
                 i++;
             }
             i--;
             ansList.add(list);
        }
        
        return ansList;
    }
    class Pair{
        String str;
        int idx;
        Pair(String str, int idx){
            this.str = str; this.idx = idx;
        }
    }
}
// aet aet ant aet ant abt
  //  0   1   2   3   4   5
// avnish
// hvinas
// sinvah
// isnvah
