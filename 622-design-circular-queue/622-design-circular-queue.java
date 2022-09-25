class MyCircularQueue {
    int []arr;
    int rear;
    int front;
    int size;
    int length;
    public MyCircularQueue(int k) {
        arr = new int[k];
        rear = 0; front = 0; size = 0;
        length = k;
    }
    
    public boolean enQueue(int value) {
        if (size == length)
            return false;
        arr[ rear ] = value;
        rear = (rear + 1) % length;
        size++; return true;
    }
    
    public boolean deQueue() {
        if(size == 0) return false;
        front = (front + 1) % length;
        size--; return true;
    }
    
    public int Front() {
        if(size == 0) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(size == 0) return -1;
        if(rear == 0){
            return arr[arr.length - 1];
        }
        else {
            return arr[rear-1];
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */