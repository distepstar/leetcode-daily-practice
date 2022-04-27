package Datatypes;


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public String printAll(){
        String res = Integer.toString(val) + " ";
        if(next != null){
            res += next.printAll();
        }

        return res;
    }
    
}

