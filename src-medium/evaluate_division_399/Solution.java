package evaluate_division_399;

//    You are given equations in the format A / B = k, where A and B are variables represented as strings,
//    and k is a real number (floating-point number). Given some queries, return the answers.
//    If the answer does not exist, return -1.0.
//
//    The input is always valid.
//    You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

//    Constraints:
//            1 <= equations.length <= 20
//            equations[i].length == 2
//            1 <= equations[i][0], equations[i][1] <= 5
//            values.length == equations.length
//            0.0 < values[i] <= 20.0
//            1 <= queries.length <= 20
//            queries[i].length == 2
//            1 <= queries[i][0], queries[i][1] <= 5
//            equations[i][0], equations[i][1], queries[i][0], queries[i][1] consist of lower case English letters and digits.

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // [6.0, 0.5, -1.0, 1.0, -1.0]
        // [3.75, 0.4, 5.0, 0.2]
        // [0.5, 2.0, -1.0, -1.0]
        String[][][] testCasesEquations = {{{"a", "b"}, {"b", "c"}}, {{"a", "b"}, {"b", "c"}, {"bc", "cd"}}, {{"a", "b"}}};
        double[][] testCasesValues = {{2.0, 3.0}, {1.5, 2.5, 5.0}, {0.5}};
        String[][][] testCasesQueries = {{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}},
                {{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}}, {{"a", "b"}, {"b", "a"}, {"a", "c"}, {"x", "y"}}};
        for(int i = 0; i < testCasesValues.length; i++) {
            List<List<String>> equations = Arrays.stream(testCasesEquations[i]).map(Arrays::asList).collect(Collectors.toList());
            List<List<String>> queries = Arrays.stream(testCasesQueries[i]).map(Arrays::asList).collect(Collectors.toList());
            System.out.println(Arrays.toString(solution.calcEquation(equations, testCasesValues[i], queries)));
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Node> nodes = new HashMap<>();
        
        // connect the neighbor nodes
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String id1 = equation.get(0);
            String id2 = equation.get(1);
            nodes.putIfAbsent(id1, new Node(id1));
            nodes.putIfAbsent(id2, new Node(id2));
            
            nodes.get(id1).neighbors.put(nodes.get(id2), values[i]);
            nodes.get(id2).neighbors.put(nodes.get(id1), 1 / values[i]);
        }
        
//        System.out.println(nodes);
        
        // get query result
        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String id1 = query.get(0);
            String id2 = query.get(1);
            if(nodes.get(id1) == null || nodes.get(id2) == null)
                result[i] = -1.0;
            else if(id1 == id2)
                result[i] = 1.0;
            else
                result[i] = dfs(nodes.get(id1), nodes.get(id2));
        }
        
        return result;
    }
    
    public double dfs(Node node1, Node node2) {
        if(node1.neighbors.containsKey(node2))
            return node1.neighbors.get(node2);
        
        Set<String> visited = new HashSet<>();
        return dfs(node1, node2, visited, 1.0);
    }
    
    public double dfs(Node node1, Node node2, Set<String> visited, double product) {
        if(visited.contains(node1.id))
            return -1;
        
        visited.add(node1.id);
        if(node1.neighbors.containsKey(node2))
            return product * node1.neighbors.get(node2);
        
        for(Node neighbor : node1.neighbors.keySet()) {
            double result = dfs(neighbor, node2, visited, product * node1.neighbors.get(neighbor));
            if(result != -1)
                return result;
        }
        
        return -1;
    }
}

class Node {
    String id;
    public Map<Node, Double> neighbors = new HashMap<>();;
    
    public Node(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append("id: ").append(id).append(", neighbors: ").append(neighbors.values()).toString();
    }
}

//    Runtime: 1 ms, faster than 71.85% of Java online submissions for Evaluate Division.
//    Memory Usage: 38.1 MB, less than 61.80% of Java online submissions for Evaluate Division.
