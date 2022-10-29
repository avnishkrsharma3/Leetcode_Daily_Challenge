class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
      Pair [] arr = new Pair[plantTime.length];
        for(int i = 0; i < plantTime.length; i++){
            Pair p = new Pair(plantTime[i], growTime[i]);
            arr[i] = p;
        }
        Arrays.sort(arr, (p1, p2) -> p2.gt - p1.gt);
        
        int time = 0;
        int grwt = 0;
        for(int i = 0; i < arr.length; i++){
            time += arr[i].pt;
            grwt += arr[i].gt;
            if(i < arr.length - 1){
                // if( grwt >= arr[i+1].pt ){
                //     grwt -= arr[i+1].pt;
                //     if(grwt >= arr[i+1].gt ){
                //         grwt -= arr[i+1].gt;
                //     }
                //     else{
                //         grwt = 0;
                //     }
                // }
                // else{
                //     grwt = 0;
                // }
                if(grwt - (arr[i+1].pt + arr[i+1].gt) > 0){
                    grwt -= (arr[i+1].pt + arr[i+1].gt);
                }
                else{
                    grwt = 0;
                }
            }
        }
        
        return time +  grwt ;
    }
    class Pair{
        int pt = 0;
        int gt = 0;
        Pair(int p, int g){
            pt = p;
            gt = g;
        }
    }
}