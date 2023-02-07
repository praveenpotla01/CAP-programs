class Solution {
    int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c, char[][] grid){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]!='1')
            return;
        grid[r][c]='0';
        for (int i=0; i<4; i++) {
            dfs(r+d[i][0], c+d[i][1], grid);
        }
    }
}