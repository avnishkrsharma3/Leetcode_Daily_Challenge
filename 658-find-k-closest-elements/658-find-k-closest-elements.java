class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int [][]twoD = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            twoD[i][0] = arr[i];
            twoD[i][1] = Math.abs(arr[i]  - x);
        }
        Arrays.sort(twoD, (a, b)->{
            if(a[1] > b[1]){
                return 1;
            }
            else if(a[1] == b[1]){
                return a[1]  - b[1];
            }
            else 
                return -1;
        });
    
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < k; i++){
            list.add(twoD[i][0]);
        }
    
        Collections.sort(list);
    
        return list;
     }  
}