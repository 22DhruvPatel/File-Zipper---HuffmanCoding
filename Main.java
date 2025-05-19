public class Main {
    public static void main(String[] args) {
        String input = "hello huffman";

        HuffmanCoder coder = new HuffmanCoder(input);

        String encoded = coder.encode(input);
        System.out.println("Encoded: " + encoded);

        String decoded = coder.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
