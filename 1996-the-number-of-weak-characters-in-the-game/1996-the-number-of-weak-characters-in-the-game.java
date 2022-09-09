class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? (a[1] - b[1]) : (b[0] - a[0]));
        int max  = properties[0][1];
        int cnt = 0;
        for(int i = 0;  i < properties.length; i++){
            if(max > properties[i][1]){
                cnt++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return cnt;
    }
}