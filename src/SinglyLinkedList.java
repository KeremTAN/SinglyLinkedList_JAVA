public class SinglyLinkedList<T> {

    private Node<T> head;

    private Node<T> tail;

    private int numberOfNodes;

    public SinglyLinkedList() {
        head = tail = null;
        numberOfNodes = 0;
    }

    public void add(String value) {
        Node<T> temp = new Node<>(value);

        if (head == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.setNext(temp);
            tail = temp;
        }

        numberOfNodes ++;
    }
    public void add(int position, String value) {
        Node<T> tempData = new Node<>(value);
        Node<T> temp = head;
        Node<T> protect = null;
        Node<T> move = null;
        Node<T> then = temp;
        Node<T> before = null;
        int i = 0;
        if (head == null) {
            head = temp;
            tail = temp;
            System.err.println("Your value must be 0. index");
        } else {
            if (position < numberOfNodes && position > 0) {
                while (temp != null) {
                    before = then;
                    then = temp;
                    if (i == position)
                        break;
                    temp = temp.getNext();
                    i++;
                }
                before.setNext(tempData);
                tempData.setNext(then);
                then = tempData;
                tail = then;
                numberOfNodes++;
            }
            else if(position==0){
                temp = head;
                then = head.getNext();
                head=tempData;
                tempData.setNext(temp);
                temp.setNext(then);
                numberOfNodes++;
            }
            else if (numberOfNodes==position)
                add(value);

        }
    }
    public void remove(int location){
        int i = 0;
        Node<T> temp = head;
        Node<T> then = temp;
        Node <T> before =null;
        while (temp != null) {
            before = then;
            then = temp;
            if (i==location)
                break ;
            temp = temp.getNext();
            i++;
        }
        before.setNext(then.getNext());
        tail = then;

        numberOfNodes =numberOfNodes-1;

    }
    public void remove(String item){
        int i = 0;
        Node<T> temp = head;
        Node<T> then = temp;
        Node <T> before =null;
        while (temp != null) {
            before = then;
            then = temp;
            if (temp.getData().equals(item))
                break ;

            temp = temp.getNext();
            i++;
        }
        before.setNext(then.getNext());
        tail = then;

        numberOfNodes =numberOfNodes-1;
    }


    public int indexOf(String value) {
        int i = 0;
        Node<T> temp = head;

        while (temp != null) {
            if (temp.getData().equals(value))
                return i;
            i ++;
            temp = temp.getNext();

        }
        return -1;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public String first() {
        return isEmpty() ? null : head.getData();
    }

    public String last() {
        return isEmpty() ? null : tail.getData();
    }

    public String get(int position) {
        String s="";
        if (position < 0 || numberOfNodes <= position) {
            s= "There is no value";
        }

        int i = 0;
        Node<T> temp = head;

        while (temp != null) {
            if (position == i)
                s=temp.getData();

            i ++;
            temp = temp.getNext();
        }
        return s;
    }
    public int size() {
        return numberOfNodes;
    }
}
