package practice;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites){

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        boolean [] visited = new boolean[numCourses];
        boolean [] instack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(dfs(i,adj,instack,visited))
                return false;

        }



        return true;

    }

    private static boolean dfs(int node, List<List<Integer>> adj, boolean[] instack, boolean[] visited) {

        if(instack[node])
            return true;
        if(visited[node])
            return false;
        visited[node] = true;
        instack[node]=true;
        for(int neighbour:adj.get(node)){
            if(dfs(neighbour,adj,instack,visited)){
                return true;
            }
        }
        instack[node]=false;
        return false;
    }


    public static boolean canFinish1(int numCourses, int[][] prerequisites) {

        int [] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        int nodesCovered=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            nodesCovered++;
            for(int  neighbor:adj.get(node)){

                inDegree[neighbor]--;
                if(inDegree[neighbor]==0)
                    queue.add(neighbor);
            }

        }
        return nodesCovered==numCourses;
    }



    public static void main(String[] args) {

        int[][] prerequisites= {{1,0},{2,1},{3,2},{3,1},{3,0}};
        int courses=4;
        System.out.println(canFinish(courses,prerequisites));


    }
}
