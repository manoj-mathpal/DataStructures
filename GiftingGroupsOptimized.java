package amazonPrep;

import java.util.*;
public class GiftingGroupsOptimized {

    public static int findGroups(List<String> list) {
        int[][] arr = convertListToArray(list);
        boolean[] visited = new boolean[arr.length];
        int groupCount=0;
        for(int i=0;i<arr.length;i++)
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


    public static int[][] convertListToArray(List<String> stringList) {
        return stringList.stream()
                .map(row -> Arrays.stream(row.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
    }


    public static void main(String[] args) {
        String given3[] = {"110", "110", "001"};
        List<String> arrayList = Arrays.asList(given3);
        int result = findGroups(arrayList);
        System.out.println(result);


    }

}
