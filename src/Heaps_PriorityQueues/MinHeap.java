package Heaps_PriorityQueues;

public class MinHeap {

    // Member variables of the class
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int Front = 1;

    // constructor of this class
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;

    }

    /*
    Method 1
    Returning the position of the parent of current node at pos
     */

    private int parent(int pos) {
        return pos / 2;
    }


/*
    Method 2
    Returning the position of the left for current  node at pos
     */

    private int leftchild(int pos) {
        return 2 * pos;
    }

/*
    Method 3
    Returning the position of the right for current  node at pos
     */

    /* method 4 returning true if leaf is passed

    Checking if a node is a leaf node is a way to optimize the minHeapify process. If a node is a leaf, it means it has no children.
    Since the heap property only concerns the relationship between parent and child nodes, a leaf node, by definition, cannot violate this property. Therefore, if a node is a leaf, the minHeapify process does not need to
    continue further down that path, saving unnecessary computations.
     */

    private boolean isLeaf(int pos) {
        if (pos > (size / 2)) {
            return true;
        }

        return false;
    }


    private int rightchild(int pos) {
        return 2 * pos + 1;
    }

    private void swap(int fpos, int spos) {
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    private void minHeapify(int pos) {

        if (!isLeaf(pos)) {
            int swapPos = pos;

            // swap with the min of the two children
            // check if the right child exists . otherwise default value will be 0
            // and that will be swapped with parent node

            if (rightchild(pos) <= size)
                swapPos = Heap[leftchild(pos)] < Heap[rightchild(pos)] ? leftchild(pos) : rightchild(pos);

            else
                swapPos = leftchild(pos);

            if (Heap[pos] > Heap[leftchild(pos)] || Heap[pos] > Heap[rightchild(pos)]) {
                swap(pos, swapPos);
                minHeapify(swapPos);
            }
        }

    }

    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 0; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + Heap[i]
                            + " LEFT CHILD : " + Heap[2 * i]
                            + " RIGHT CHILD :" + Heap[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }

    // Method 9
    // To remove and return the minimum
    // element from the heap
    public int remove() {

        int popped = Heap[Front];
        Heap[Front] = Heap[size--];
        minHeapify(Front);

        return popped;
    }

    public static void main(String[] args) {


            // Display message
            System.out.println("The Min Heap is ");

            // Creating object of class in main() method
            MinHeap minHeap = new MinHeap(15);

            // Inserting element to minHeap
            // using insert() method

            // Custom input entries
            minHeap.insert(5);
            minHeap.insert(3);
            minHeap.insert(17);
            minHeap.insert(10);
            minHeap.insert(84);
            minHeap.insert(19);
            minHeap.insert(6);
            minHeap.insert(22);
            minHeap.insert(9);

            // Print all elements of the heap
            minHeap.print();

            System.out.println("The Min val is "
                    + minHeap.remove());
    }

}





