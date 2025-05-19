# HuffmanCoder

HuffmanCoder is a Java implementation of the Huffman Encoding algorithm for efficient lossless data compression and decompression. This project demonstrates how Huffman Trees are used to generate optimal prefix codes for characters based on their frequencies in a given input string.

## 📌 Features

- Build a Huffman Tree from any input text
- Encode plain text into a compressed binary string
- Decode binary strings back to original text
- Display Huffman codes for all characters
- Clean, object-oriented design with well-commented code

## 💡 What is Huffman Coding?

Huffman coding is a greedy algorithm used for data compression. It assigns variable-length binary codes to input characters, with shorter codes assigned to more frequent characters. This leads to efficient representation and reduced overall data size.

---

## 🧠 How It Works

1. **Frequency Analysis** – Count occurrences of each character.
2. **Min-Heap Construction** – Store each character as a node in a priority queue based on frequency.
3. **Huffman Tree Building** – Combine lowest-frequency nodes into a binary tree.
4. **Encoding Map Creation** – Traverse tree to assign binary codes to each character.
5. **Encoding** – Replace each character in input string with its binary code.
6. **Decoding** – Traverse binary string using Huffman tree to reconstruct original string.

---

## 🔧 Project Structure

```bash
HuffmanCoder/
├── HuffmanCoder.java   # Main class implementing Huffman compression and decompression
└── README.md           # Project documentation

```


📦 Requirements
Java JDK 8 or above



🙋‍♂️ Author
Dhruv Patel
