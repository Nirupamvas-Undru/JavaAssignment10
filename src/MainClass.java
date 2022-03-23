class Node {
    String data;
    Node next;
    Node(String data, Node next){
        this.data=data;
        this.next=next;
    }
    Node(String data){
        this(data, null);
    }
    public String toString() {
        if (data == null)
            return "null";
        return data;
    }
};

class SList {
    Node head = new Node(null);
    public SListIterator iterateList() {
        return new SListIterator(head);
    }
    public String toString() {
        if(head==null) {
            return "list is empty: ";
        }
        SListIterator iterator = this.iterateList();
        StringBuilder s=new StringBuilder();
        while (iterator.hasNext()) {
            s.append(iterator.next() + (iterator.hasNext() ? ", " : ""));
        }
        return ""+s;
    }
};

class SListIterator {
    Node temp;
    SListIterator(Node node){
        this.temp = node;
    }
    public Node next() {
        temp = temp.next;
        return temp;
    }
    public boolean hasNext() {
        return temp.next!=null;
    }
    public void insertNode(String data) {
        temp.next = new Node(data, temp.next);
        temp = temp.next;
    }
    public void removeNode() {
        if(temp.next != null) {
            temp.next = temp.next.next;
        }
    }
};

class MainClass {

    public static void main(String[] args) {
        SList sList = new SList();
        SListIterator sListIterator = sList.iterateList();
        System.out.print(sList);
        sListIterator.insertNode("22");
        sListIterator.insertNode("2");
        System.out.println(sList);
        SListIterator obj3 = sList.iterateList();
        obj3.removeNode();
        System.out.println(sList);

    }

}