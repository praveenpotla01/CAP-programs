class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
            return -1;
        int rowl=grid.length;
        int coll=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2)
                    q.offer(new int[] {i,j});
            }
        }
        if(fresh==0)
            return 0;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] rotten=q.poll();
                for(int[] d:dir){
                    int r=d[0]+rotten[0];
                    int c=d[1]+rotten[1];
                    if(r>=0 && r<rowl && c>=0 && c<coll && grid[r][c]==1){
                        grid[r][c]=2;
                        q.add(new int[] {r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh!=0)
            return -1;
        if(time>0)
            return time-1;
        else
            return 0;
    }
}