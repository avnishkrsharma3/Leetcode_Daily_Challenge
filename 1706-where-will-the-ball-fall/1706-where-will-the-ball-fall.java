class Solution {
    public int[] findBall(int[][] grid) {
        int [] arr = new int[grid[0].length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = util(grid, 0, i);
        }
        return arr;
    }
    public int util(int [][] grid, int row, int col){
        if(row == grid.length - 1){
            if(grid[row][col] == 1){
                if(col == grid[0].length - 1)
                    return -1;
                 else{
                     if(grid[row][col+1] == -1)
                         return -1;
                     else{
                         return col+1;
                     }
                 }
            }else{
                if(col == 0)
                    return -1;
                 else{
                     if(grid[row][col-1] == 1)
                         return -1;
                     else{
                         return col-1;
                     }
                 }
            }
        }
        
        if(grid[row][col] == -1){
            if(col-1>=0){
                if(grid[row][col-1] == -1){
                    return util(grid, row+1, col - 1);
                }else
                    return -1;
            }
            else
                return -1;
        }
        else{
             if(col+1 <= grid[0].length-1){
                if(grid[row][col+1] == 1){
                    return util(grid, row+1, col + 1);
                }else
                    return -1;
            }
            else 
                return -1;
        }
    }
}