class TrieNode {
    Map<String, TrieNode> children;
    String hashValue = "";
    boolean isEnd = false;

    public TrieNode() {
        this.children = new HashMap<>();
    }
}

class Trie {
    final TrieNode root = new TrieNode();
    Map<String, Integer> hashFrequency = new HashMap<>();
    List<List<String>> paths = new ArrayList<>();

    public void insert(List<String> path) {
        TrieNode curr = root;
        for (String folder : path) {
            curr = curr.children.computeIfAbsent(folder, _ -> new TrieNode());
        }
        curr.isEnd = true;
    }

    public String computeHashes(TrieNode node) {
        if (node.children.isEmpty()) return "";

        StringBuilder hashValue = new StringBuilder();
        List<String> childHashes = new ArrayList<>();

        for (String childKey : node.children.keySet()) {
            childHashes.add(childKey + "," + computeHashes(node.children.get(childKey)));
        }

        Collections.sort(childHashes);
        hashValue.append("(").append(String.join("", childHashes)).append(")");
        node.hashValue = hashValue.toString();
        hashFrequency.put(node.hashValue, hashFrequency.getOrDefault(node.hashValue, 0) + 1);

        return node.hashValue;
    }

    public void generateUniquePaths(List<String> path) {
        TrieNode curr = root;
        for (String folder : path) {
            TrieNode child = curr.children.get(folder);
            if (!child.hashValue.isEmpty() && hashFrequency.get(child.hashValue) > 1) {
                return;
            }
            curr = child;
        }
        paths.add(path);
    }
}

class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie trie = new Trie();
        for (List<String> path : paths) {
            trie.insert(path);
        }
        trie.computeHashes(trie.root);
        for (List<String> path : paths) {
            trie.generateUniquePaths(path);
        }
        return trie.paths;
    }
}