import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
            ArrayList<Integer> myList = new ArrayList<>();
            myList.add(10);
            myList.add(30);
            myList.add(20);
            myList.add(30);
           ArrayList<Number> myList2 = new ArrayList<>();

            for (int element = 0; element < myList.size();element++) {
                System.out.println(myList.get(element));
        }
        System.out.println(myList.contains(10));
        System.out.println(myList.remove(0));


        myList2.add(45);
        myList2.add(32);
        myList2.add(100);
        System.out.println(myList2.indexOf(32));
        System.out.println(myList2.indexOf(1000));
        System.out.println(myList.lastIndexOf(30));
        System.out.println(myList.toString());
        ArrayList<Integer> myList1 = myList;
        System.out.println(myList2.addAll(0, myList1));
        System.out.println(myList2.containsAll( myList1));
        System.out.println(myList.hashCode());
        System.out.println(myList2.isEmpty());
        System.out.println(Arrays.toString(myList.toArray()));






    }
}