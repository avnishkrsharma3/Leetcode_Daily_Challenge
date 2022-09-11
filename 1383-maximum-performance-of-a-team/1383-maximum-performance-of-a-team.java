class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1000000007;
        int [][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        int sum = 0;
        int mul = 100000005;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = Long.MIN_VALUE;
        long totalSpeed = 0;
        for(int [] eng : arr){
            if(pq.size() == k) totalSpeed -= pq.poll();
            pq.add(eng[0]);
            totalSpeed = (totalSpeed + eng[0]);
            res = Math.max(res, (totalSpeed * eng[1]));
        }
        return (int)(res % mod);
    }
}
// 9 7 5 4  3 2
// 1 5 2 10 3 8
/*
PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
long res = Long.MIN_VALUE, totalSpeed = 0;

for (int[] engineer : engineers) {
	if (pq.size() == k) totalSpeed -= pq.poll();  // layoff the one with min speed
	pq.add(engineer[1]);
	totalSpeed = (totalSpeed + engineer[1]);
	res = Math.max(res, (totalSpeed * engineer[0]));  // min efficiency is the efficiency of new engineer
}*/
