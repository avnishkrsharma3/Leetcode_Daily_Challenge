// class Solution {
//     int dp[][][];
//     public int shortestPath(int[][] grid, int k) {
//         dp = new int[grid.length][grid[0].length][k+1];
//         int ans = util(grid, new int[grid.length][grid[0].length], 0, 0, k);
//         if(ans == 10001) return -1;
//         else return ans;
//     }
//     public int util(int [][]grid, int[][]visited, int row, int col, int k){
//         if(row == grid.length - 1 && col == grid[0].length - 1){
//             return 0;
//         }
//         if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
//             return 1601;
//         }
//         int left = 1601;
//         int up = 1601;
//         int right = 1601;
//         int down = 1601;
//         int min = 10000;
//         if(dp[row][col][k]!= 0) return dp[row][col][k];
//         if(row + 1 < grid.length){
//             if(visited[row+1][col ] == 0 ){
//                 if(grid[row + 1][col] == 0){
//                 visited[row+1][col] = 1;
//                 down = util(grid, visited, row+1, col, k);
//                 visited[row + 1][col] = 0;
//                 min = Math.min(min, down);
//               //  System.out.println("d");
//                 }
//                 else if(k > 0){
//                 visited[row+1][col] = 1;
//                     k--;
//                 down = util(grid, visited, row+1, col, k);
//                 visited[row + 1][col] = 0;
//                 min = Math.min(min, down);
//               //  System.out.println("d");
//                     k++;
//                 }
//             }
//         }
//          if(col + 1 < grid[0].length){
//             if(visited[row][col + 1 ] == 0 ){
//                 if(grid[row][col+1] == 0){
//                 visited[row][col  + 1] = 1;
//                 right = util(grid, visited, row, col + 1, k);
//                 visited[row ][col + 1] = 0;
//                 min = Math.min(min, right);
//                //  System.out.println("r");
//                 }else if(k > 0){
//                 visited[row][col  + 1] = 1;
//                     k--;
//                 right = util(grid, visited, row, col + 1, k);
//                 visited[row ][col + 1] = 0;
//                 min = Math.min(min, right); k++;
//                //  System.out.println("r"); k++;
//                 }
//             }
//         }
//          if(row - 1 >= 0){
//             if(visited[row-1][col ] == 0 ){
//                 if( grid[row -1 ][col] == 0){
//                 visited[row-1][col] = 1;
//                 up = util(grid, visited, row-1, col , k);
//                 visited[row - 1][col] = 0;
//                 min = Math.min(min, up);
//                 // System.out.println("u"); 
//                 }else if(k > 0){
//                     visited[row-1][col] = 1; k--;
//                 up = util(grid, visited, row-1, col, k);
//                 visited[row - 1][col] = 0;
//                 min = Math.min(min, up); k++;
//                 // System.out.println("u"); k++;
//                 }
//             }
//         }
//         if(col - 1 >= 0){
//             if(visited[row][col - 1 ] == 0 ){
//                 if(grid[row][col-1] == 0){
//                      visited[row][col  - 1] = 1;
//                 left = util(grid, visited, row, col - 1, k);
//                 visited[row ][col - 1] = 0;
//                 min = Math.min(left, min);
//                //  System.out.println("l");
//                 }
//                 else if(k > 0){
//                 visited[row][col  - 1] = 1; k--;
//                 left = util(grid, visited, row, col - 1, k);
//                 visited[row ][col - 1] = 0;
//                 min = Math.min(left, min); k++;
//                 // System.out.println("l"); k++;
//                 }
//             }
//         }
//         return dp[row][col][k]  = min + 1;
        
//     }
// }
class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList();
        boolean[][][] visited = new boolean[n][m][k+1];
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] info = q.poll();
                int r = info[0], c = info[1], curK = info[2];
                if(r==n-1 && c==m-1){
                    return res;
                }
                for(int[] dir : dirs){
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;
                    if(nextR>=0 && nextR<n && nextC>=0 && nextC<m){
                        if(grid[nextR][nextC]==1){
                            nextK++;
                        }
                        if(nextK<=k && !visited[nextR][nextC][nextK]){
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }                
            }
            res++;
        }
        return -1;
    }
}