// Time Complexity :O(nlogn) 
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

public class Main {
    public static void main(String[] args) {
       
        System.out.println(meeting(new int[][]{{2,7}}));
    }
    public static int meeting(int[][] matrix)
    {
        int rooms=0;
        Arrays.sort(matrix,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();//min heap
        for(int[] row:matrix)
        {
            if(pq.isEmpty())
            {
                pq.add(row[1]);
                rooms+=1;
            }
            else{
                int top=pq.peek();
                if(top<row[1]){
                    pq.poll();
                    rooms-=1;
                    pq.add(row[1]);
                    rooms+=1;
                }
                else{
                    pq.add(row[1]);
                    rooms+=1;
                }
            }
        }
        return rooms;
    }
}