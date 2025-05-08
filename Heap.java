import java.util.ArrayList;
import java.util.*;
import java.util.Collection;

/**
 *
 * @param <T> type of elements, must be comparable.
 */
public class Heap<T extends Comparable<T>> {
    private final ArrayList<T> heap;

    public Heap() {
      heap = new ArrayList<>();
    }

    /** Return the size of heap. **/
    public int size() {
        return heap.size();
    }

    /** Returns the minimum element without removing it. **/
    public T peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is Empty");
        return heap.get(0);
    }


    /** Inserts a new element into the heap. **/
    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }


    /** Removes and returns the minimum element. **/
    public T remove() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is Empty");

        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }


    /** Returns a sorted list (heap will be empty after this) */
    public ArrayList<T> heapSort() {
        ArrayList<T> sorted = new ArrayList<>();
        while (!heap.isEmpty()) {
            sorted.add(remove());
        }
        return sorted;
    }




    // ----- Internal Helpers -------

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1)/2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                Collections.swap(heap, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }


    private void heapifyDown(int index) {
        int size  = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index){
                Collections.swap(heap, index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }


    /** Debug method: Returns current heap as a list */
    public ArrayList<T> toList() {
        return new ArrayList<>(heap); // return a copy
    }

}
