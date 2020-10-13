import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyBinaryHeap {
    private static  final  int d = 2;//代表分叉个数
    private int[] heap;
    private int size;
    public MyBinaryHeap(int capacity) {
        size = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }
    public boolean isEmpty() {//判断是否为空
        return size == 0;
    }
    public boolean isFull() {
        return size == heap.length;
    }

    private int parent(int i) {//找父母节点
        return (i - 1) / d;
    }
    private int child(int i, int k) {//找孩子节点
        return i * d + k;
    }

    public void insert(int x) {//先插入到末尾，再进行堆排序
        if (isFull()) {
            throw new NoSuchElementException("Heap is full,no space to insert new element.");
        }
        heap[size] = x;
        size++;
        heapifyUp(size - 1);
    }
    private void heapifyUp(int i) {
        int inserValue = heap[i];
        while (i > 0 && heap[i] > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = inserValue;
    }

    public  int delete(int x) {
        if (isEmpty()) {
           throw new NoSuchElementException("Heap is empty,no element to delete");
        }
        int maxElement = heap[x];
        heap[x] = heap[size - 1];
        size--;
        heapifyDown(x);
        return  maxElement;
    }
    private void heapifyDown(int i) {
        int child_index;
        int temp = heap[i];//临时保存要修改的值
        while (child(i, 1) < size) {//确保孩子的下标不会超过size
            child_index = maxChild(i);
            if (temp > heap[child_index])
                break;
            heap[i] = heap[child_index];
            i = child_index;
        }
        heap[i] = temp;
    }
    private int maxChild(int i) {
        int leftChild = child(i,1);
        int rightChild = child(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public int findMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }

    public static void main(String[] args) {
        MyBinaryHeap maxHeap = new MyBinaryHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);


        maxHeap.printHeap();
        maxHeap.delete(5);
        maxHeap.printHeap();
        maxHeap.delete(2);
        maxHeap.printHeap();
    }
}
