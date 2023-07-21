
public class Main {
    public static void main(String[] args) {
            ArrayList<Integer> myList = new ArrayList<>();
            myList.add(10);
            myList.add(20);
            myList.add(30);


            for (int element = 0; element < myList.size();element++) {
                System.out.println(myList.get(element));
        }
        System.out.println(myList.contains(10));
        System.out.println(myList.remove(0));


    }
}