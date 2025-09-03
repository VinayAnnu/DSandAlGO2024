package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String[] words) {
        // Step 1: Initialize data structures
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        // Add all unique chars
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 2: Build graph using adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Invalid case: prefix issue
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break; // only first difference matters
                }
            }
        }

        // Step 3: BFS (Kahn’s Algorithm)
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            for (char nei : adj.get(c)) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    queue.add(nei);
                }
            }
        }

        // Step 4: Check if topo sort includes all characters
        if (sb.length() < indegree.size()) {
            return ""; // cycle detected
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        AlienDictionary sol = new AlienDictionary();

        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        String[] words2 = {"z","x"};
        String[] words3 = {"z","x","z"}; // invalid (cycle)

        System.out.println(sol.findOrder(words1)); // Possible: "wertf"
        System.out.println(sol.findOrder(words2)); // "zx"
        System.out.println(sol.findOrder(words3)); // ""
    }
}
