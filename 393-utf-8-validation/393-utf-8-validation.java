class Solution {
    public boolean validUtf8(int[] data) {
        
        for(int i  = 0; i < data.length; i++){            
            int nByte = nByte(data[i]);
          //  System.out.println(nByte + "  " );
            if(nByte == 1 || nByte > 4) return false;
            int j  = 0;
            for(j = i+1; j < i+nByte; j++){
                if(j >= data.length || isCorrect(data[j]) == false)
                    return false;
            }
            i = j-1;          
        }
          return true;
    }
    
    public int nByte(int val){
        int k = 7;
        int bitMask = 1 << k;
        while((val & bitMask) >= 1 && k > 0){
            k--;
            bitMask = 1 << k;
        }
        int ans = 7 - k;
        return ans;
    }
    public boolean isCorrect(int val){
        int k = 7;
        int bitMask = 1 << k;
        int bitMask2 = 1 << 6;
         if(((val & bitMask) >= 1 ) && ((val & bitMask2) == 0))
             return true;
         return false;
    }
}