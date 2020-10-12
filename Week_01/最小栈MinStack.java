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
//     }//方法一 用已存在的栈类 实现
//方法二 用数组实现（不推荐，不能动态处理问题）
//方法三 用链表实现
class MinStack {
    //用链表
    class Node {
        int val;
        int min;
        Node next;
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    Node head;
    public MinStack() {
    }
    
    public void push(int x) { 
        if (head != null)
           head = new Node(x, Math.min(x, head.min), head); 
        else 
            head = new Node(x, x, null);
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
}

// class MinStack {
//     //用java内置的stack实现
//     //且辅助栈与数据栈不同步（可以节约一些空间）
//     Stack<Integer> data;
//     Stack<Integer> helper;
//     public MinStack() {
//         data = new Stack<Integer>();
//         helper = new Stack<Integer>();
//     }
    
//     public void push(int x) {
//         data.push(x);
//         if (helper.empty() || x <= helper.peek())
//             helper.push(x);
//     }
    
//     public void pop() {
//         // int x = data.pop();
//         // if (x == helper.peek())
//         //     helper.pop();
//         Integer x = data.pop();
//         if (x.equals(helper.peek()))
//             helper.pop();
//     }
    
//     public int top() {
//         return data.peek();
//     }
    
//     public int getMin() {
//         return helper.peek();
//     }
// }


// class MinStack {
//     //用已有的栈实现 且辅助栈与数据栈同步
//     Stack<Integer> stack;
//     Stack<Integer> minStack; 
//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new Stack<Integer>();
//         minStack = new Stack<Integer>();
//     }
    
//     public void push(int x) {
//         stack.push(x);
//         if (minStack.empty() || x <= minStack.peek()) {
//             minStack.push(x);
//         } else {
//             minStack.push(minStack.peek());
//         }
//     }
    
//     public void pop() {
//         stack.pop();
//         minStack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }
// class MinStack {

//     /** initialize your data structure here. */
//     public MinStack() {

//     }
    
//     public void push(int x) {

//     }
    
//     public void pop() {

//     }
    
//     public int top() {

//     }
    
//     public int getMin() {

//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
    
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