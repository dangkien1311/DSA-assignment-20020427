import java.util.*;

public class Solution {

    static Node head;
    static Node a;
    static Node b;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    //BT1
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    //BT2
    public Node Inserttail(Node node, int data) {
        Node new_node = new Node(data);
        if (node == null) {
            node = new_node;
            return node;
        }
        Node tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new_node;
        return node;
    }
    //BT3
    public Node Inserthead(int data) {
        Node new_head = new Node(data);
        new_head.next = head;
        head = new_head;
        return new_head;
    }
    //BT4
    public Node Insertposition(Node node, int data, int position) {

        Node Pos = new Node(data);
        if(position == 1) {
            Pos.next = head;
            head = Pos;
            return Pos;
        }
        for(int i = 1; i <position; i++){
            Pos = head;
            head = head.next;
        }
        Node new_node = new Node(data);
        new_node.next = Pos.next;
        Pos.next = new_node;
        return node;
    }
    //BT5
    public Node deleteNode(Node node, int position) {
        Node temp = head;
        if(position == 1) {
            head = temp.next;
            return head;
        }
        Node Pos = new Node(node.data);
        for(int i = 1; i < position ; i++)
        {
            Pos = head;
            head = head.next;
        }
        Pos.next = Pos.next.next;
        return node;
    }
    //BT6
    public void reversePrint(Node node) {
        List<Integer> arr = new ArrayList<>();
        int i = 0;
        Node tail = node;
        while (tail != null) {
            arr.add(tail.data);
            tail = tail.next;
            i++;
        }
        for(int j = i -1 ;j >= 0;j--) {
            System.out.print(arr.get(j)+" ");
        }
    }
    //BT7
    public Node reverse(Node node) {
        Node prev = null;
        Node next = null;
        Node body = node;
        while (body != null) {
            next = body.next;
            body.next = prev;
            prev = body;
            body = next;
        }
        head = prev;
        return node;
    }
    //BT8
    public boolean compareList(Node node1, Node node2) {
            Node list1 = node1;
            Node list2 = node2;
            while(list1 != null) {
                if(list1.data != list2.data) {
                     return false;
                }
                if(list1.next == null && list2.next != null) {
                    return false;
                }
                if(list2.next == null && list1.next != null) {
                    return false;
                }
                list1 = list1.next;
                list2 = list2.next;
            }
            return true;
    }
    //BT9
    public Node mergeLists(Node node1, Node node2) {
        Node New_node = null;
        Solution list2 = new Solution();
        List<Integer> arr = new ArrayList<>();
        while(node1 != null) {
            arr.add(node1.data);
            node1 = node1.next;
        }
        while (node2 != null) {
            arr.add(node2.data);
            node2 = node2.next;
        }
        Collections.sort(arr);
        for(int i = 0 ; i<arr.size();i++) {
            New_node = list2.Inserttail(New_node,arr.get(i));
        }
        return New_node;
    }
    //BT10
    public static int getNode(Node node, int positionFromTail) {
        Node tail = node;
        List<Integer> arr = new ArrayList<>();
        while(tail != null) {
            arr.add(tail.data);
            tail = tail.next;
        }
        int data = 0;
        for(int i = arr.size() -1 ; i>=0;i--) {
            data = arr.get(arr.size() - positionFromTail -1);
        }
        return data;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution list = new Solution();
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int data = scanner.nextInt();
            head = list.Inserttail(head, data);
        }
        //BT1
        //list.printList(head);

        //BT2
        /*
        int new_data = scanner.nextInt();
        head = list.Inserttail(head, new_data);
        list.printList(head);
         */

        //BT3
        /*
        int new_head = scanner.nextInt();
        head = list.Inserthead(new_head);
        list.printList(head);
        */

        //BT4
        /*
        int new_node = scanner.nextInt();
        int position = scanner.nextInt();
        if(position <= count+1) {
            head = list.Insertposition(head, new_node, position);
        }
        list.printList(head);
        */

        //BT5
        /*
        int del_position = scanner.nextInt();
        if(del_position <= count) {
            head = list.deleteNode(head, del_position);
        }
        list.printList(head);
        */

        //BT6
        //list.reversePrint(head);

        //BT7
        /*
        list.reverse(head);
        list.printList(head);
        */

        //BT8
        /*
        int count_a = scanner.nextInt();
        for (int i = 0; i < count_a; i++) {
            int data = scanner.nextInt();
            a = list.Inserttail(a, data);
        }
        int check = list.compareList(head,a)? 1:0;
        System.out.println(check);
        */

        //BT9
        /*
        int count_a = scanner.nextInt();
        for (int i = 0; i < count_a; i++) {
            int data = scanner.nextInt();
            a = list.Inserttail(a, data);
        }
        b = list.mergeLists(a,head);
        list.printList(b);
        */

        //BT10
        //thầy nên đóng phần insert ở đầu để dùng được test này ạ.
        /*
        int P_time = scanner.nextInt();
        int n = 0;
        while(n != P_time) {
            int count_b = scanner.nextInt();
            for (int i = 0; i < count_b; i++) {
                int data = scanner.nextInt();
                b = list.Inserttail(b, data);
            }
            int positionFromTail = scanner.nextInt();
            System.out.println(getNode(b, positionFromTail));
            n++;
         }
         */

    }
}
