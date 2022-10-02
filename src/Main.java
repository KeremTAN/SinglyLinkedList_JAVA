
    public class Main {

        public static void main(String[] args) {
            SinglyLinkedList s = new SinglyLinkedList();
            s.add("List1");
            s.add("List2");
            s.add("List4");
            s.add("List5");
            System.out.println(s.indexOf("List4"));
            s.add(2,"List3");
            for(int i=0; i<s.size(); i++)
                System.out.println(s.get(i));
        }

    }
