class Solution {
    public int[] findOriginalArray(int[] changed) {
        // which value can you be sure that it is not a doubled element
        // ans = starting value
        // now delete its double value
        // iterate now 
        Arrays.sort(changed);
        HashMap<Integer , Integer> set = new HashMap<>();
        for(int i : changed){
            set.put(i, set.getOrDefault(i, 0) + 1);
        }
        if(changed.length % 2 != 0) return new int[0];
        int [] ansArr = new int [changed.length/2];
        int j = 0;
        for(int i = 0; i < changed.length; i++){
            if(set.containsKey(changed[i]) && set.get(changed[i]) > 0){
                ansArr[j++] = changed[i];
                set.put(changed[i], set.get(changed[i]) - 1);
                if(set.containsKey(changed[i] * 2) && set.get(changed[i] * 2) > 0) {
                     set.put((changed[i]*2), set.get(changed[i] * 2) - 1);
                }
                else
                    return new int[0];
            }
        }
        for(Map.Entry<Integer, Integer> it : set.entrySet()){
            if(it.getValue()!=0) return new int[0];
        }
        return ansArr;
    }
}


// 1 2 3 4 6 8 
// 2 4 6 8
// 1 2 3 4  