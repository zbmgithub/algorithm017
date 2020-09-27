//方法一 利用数组模拟栈实现
//方法二 利用栈与辅助栈实现
//方法三 利用链表模拟栈实现

// class MinStack {
//     //方法一
//     int[] min;//存储每次最小值
//     int[] stack;
//     int head;
//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new int[10000]; 
//         min = new int[10000];
//         head = 0;
//     }
    
//     public void push(int x) {
//         if (head < stack.length) {
//             stack[head] = x;
//             if(head == 0 || min[head-1] > x)
//                 min[head] = x;
//             else 
//                 min[head] = min[head-1];
//             head++;
//         }
//         // System.out.print(head);
//     }
    
//     public void pop() {
//         if(head > 0)
//             head--;
//     }
    
//     public int top() {
//         if(head > 0)
//             return stack[head-1];
//         else
//             return stack[0];
//     }
    
//     public int getMin() {
//         // int min = stack[0];
//         // for(int i = 0 ; i < head; i++) {
//         //     if(min > stack[i])
//         //         min = stack[i];
//         // }
//         if(head > 0)   
//             return min[head-1];
//         else
//             return min[head];
//     }


// }

class MinStack {
    private Node head;
    
    public void push(int x) {
        if(head == null) 
            head = new Node(x, x);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min) {
            this(val, min, null);
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */