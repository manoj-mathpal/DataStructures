package amazonPrep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Province {

/*       0  1  2
    0    1  1  0       v0 - true
    1    1  1  0       v1 - true
    2    0  0  1       v2 - true
    */

    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

    public static void main(String[] args) {
        int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        Province obj = new Province();
        System.out.println(obj.findCircleNum(isConnected));


        //[[1,0,0],[0,1,0],[0,0,1]]
    }
}
