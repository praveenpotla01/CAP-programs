class Solution {
    public boolean isBipartite(int[][] graph) {
        int node = graph.length, edge = graph[0].length;
        int[] colors = new int[node];

        for (int i = 0; i < node; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph, int[] colors, int curr, int color) {
        colors[curr] = color;
        for (int neigh : graph[curr]) {
            if (colors[neigh] == colors[curr]) {
                return false;
            }
            if (colors[neigh] == 0 && !dfs(graph, colors, neigh, -color)) {
                return false;
            }
        }
        return true;
    }
}