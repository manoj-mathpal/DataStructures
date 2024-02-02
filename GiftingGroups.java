package amazonPrep;

import java.util.*;
public class GiftingGroups {


    public static int findGroups( int [][] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int groupCount=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i]){
                groupCount++;
                dfs(i,arr,visited);
            }
        }
        return groupCount;
    }

    private static void dfs(int node, int[][] arr, boolean[] visited) {
        visited[node]=true;
        for(int i=0;i<arr.length;i++){
            if(arr[node][i]==1 && !visited[i]){
                dfs(i,arr,visited);
            }
        }
    }


    public static void main(String[] args) {
        int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
//        String given3[] = {"110", "110", "001"};
//        List<String> arrayList = Arrays.asList(given3);
        int result = findGroups(isConnected);
        System.out.println(result);


    }

}
