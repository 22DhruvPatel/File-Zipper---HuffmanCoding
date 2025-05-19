import java.util.*;

/**
 * HuffmanCoder compresses and decompresses strings using Huffman Encoding.
 */
public class HuffmanCoder {

    private final Map<Character, String> encoder;
    private final Map<String, Character> decoder;

    private class Node implements Comparable<Node> {
        Character data;
        int frequency;
        Node left, right;

        Node(Character data, int frequency) {
            this.data = data;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }

    /**
     * Constructor that builds Huffman tree from the given input string.
     */
    public HuffmanCoder(String input) {
        Map<Character, Integer> freqMap = buildFrequencyMap(input);
        PriorityQueue<Node> minHeap = buildMinHeap(freqMap);
        Node root = buildHuffmanTree(minHeap);

        encoder = new HashMap<>();
        decoder = new HashMap<>();
        buildEncodingMap(root, "");
    }

    /** Builds a frequency map from the input string. */
    private Map<Character, Integer> buildFrequencyMap(String input) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    /** Builds a min-heap (PriorityQueue) from frequency map. */
    private PriorityQueue<Node> buildMinHeap(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for (var entry : freqMap.entrySet()) {
            heap.offer(new Node(entry.getKey(), entry.getValue()));
        }
        return heap;
    }

    /** Builds Huffman Tree by combining nodes with least frequency. */
    private Node buildHuffmanTree(PriorityQueue<Node> heap) {
        while (heap.size() > 1) {
            Node left = heap.poll();
            Node right = heap.poll();
            Node parent = new Node(null, left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            heap.offer(parent);
        }
        return heap.poll(); // Final root node
    }

    /** Recursively builds encoder and decoder maps from the tree. */
    private void buildEncodingMap(Node node, String path) {
        if (node == null) return;
        if (node.data != null) {
            encoder.put(node.data, path);
            decoder.put(path, node.data);
        }
        buildEncodingMap(node.left, path + "0");
        buildEncodingMap(node.right, path + "1");
    }

    /**
     * Encodes a string into a binary string using Huffman codes.
     */
    public String encode(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            result.append(encoder.get(c));
        }
        return result.toString();
    }

    /**
     * Decodes a binary string back to the original text.
     */
    public String decode(String binary) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();

        for (char bit : binary.toCharArray()) {
            currentCode.append(bit);
            if (decoder.containsKey(currentCode.toString())) {
                result.append(decoder.get(currentCode.toString()));
                currentCode.setLength(0); // reset
            }
        }

        return result.toString();
    }

    /** For debugging: Get the Huffman encoding map. */
    public Map<Character, String> getEncodingMap() {
        return encoder;
    }
}
