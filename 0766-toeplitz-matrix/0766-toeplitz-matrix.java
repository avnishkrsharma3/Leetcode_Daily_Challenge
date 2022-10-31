class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        return util(matrix);
    }
    // Each top left is equal to current value
    public boolean util(int [][] arr){
        
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[0].length; j++){
                if(i-1 >= 0 && j-1 >= 0){
                    if(arr[i-1][j-1] != arr[i][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}