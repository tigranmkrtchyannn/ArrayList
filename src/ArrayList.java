import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private static final int CAPACITY = 10;
    private Object[] element;
    private int size;


    public ArrayList() {
        this.element = new Object[CAPACITY];
        this.size = 0;
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("invalid initial capacity" + capacity);
        }
        this.element = new Object[capacity];
        this.size = 0;
    }

    private void newArrray(int minCapacity) {
        int oldCapacity = element.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            element = Arrays.copyOf(element, newCapacity);

        }

    }

    @Override
    public int capacity() {
        return element.length;
    }

    @Override
    public boolean add() {
        return false;
    }

    @Override
    public boolean contains() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E newElement) {
        newArrray(size + 1);
        element[size++] = newElement;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("invalid index" + index);
        }
        newArrray(size + 1);
        System.arraycopy(element, index, element ,index + 1, size - index);
        element[index] = value;
        size++;
    }

    @Override
    public E get(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("invalid index" + index);
        }
        return(E)element[index];
    }
    @Override
    public E set(int index , E value){
        if(index < 0 || index >=0){
            throw new ArrayIndexOutOfBoundsException("Invalid index" + index);
        }
        E previus = (E)element[index];
        element[index]=value;
        return previus;

    }
    @Override
    public boolean remove(E value){
        int index = indexOf(value);
        if(index !=1){
            remove(index);
            return true;
        }return false;
    }

    @Override
    public E remove(int index){
        if(index < 0 || index >= size){
            throw  new ArrayIndexOutOfBoundsException("Invalid index"+ index);
        }
        E removedValue = (E)element[index];
        System.arraycopy(element,index+1,element,index,size - index);
        element[--size]=null;
        return removedValue;
    }

    @Override
    public boolean contains(E value){
        for(Object x : element){
            if(x.equals(value)){
                return true;
            }
            }
        return false;
        }
    @Override
    public int indexOf(E value){
        for( int i = 0 ; i < element.length;i++){
            if(element[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value){
        for(int i = size - 1; i>=0;i--){
            if(element[i].equals(value)){
                return i;
            }
        }
        return -1;

    }
    @Override
    public  void clear(){
        Arrays.fill(element,0,size,null);
        size = 0;
    }
    @Override
    public E[] toArray(){
        return (E[])Arrays.copyOf(element,size);
    }

    @Override
    public <T> T[] toArray(T[] array){
    if(array.length<size){
        return (T[]) Arrays.copyOf(element,size,array.getClass());
    }
    for(int i = 0 ;i < array.length; i++){
        array[i] = (T)element[i];
    }
    if(array.length > size){
        array[size]=null;
    }
    return array;
 }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex){
            throw new ArrayIndexOutOfBoundsException("invalid Index" + fromIndex + " " + toIndex);
        }
        ArrayList<E> subList = new ArrayList<>(toIndex-fromIndex);
        System.arraycopy(element, fromIndex, subList.element, 0, toIndex - fromIndex);
        subList.size = toIndex - fromIndex;
        return subList;
    }

    @Override
    public boolean removeAll(List<?> otherList) {
        boolean value = false;
               for( int i = 0 ;i < otherList.size(); i++){
                   if (remove( (E) otherList.get(i))) {
                       value = true;
                   }

               }
               return  value;

  }

    @Override
    public boolean retainAll(List<E> otherList) {
       boolean value = false;
       int index = 0;
       for ( int i =0 ; i<size  ;i++) {
           E el = get(i);

           if (otherList.contains(el)) {
               element[index++] = el;
           } else {
               value = true;
           }
       }
           size = index ;
           return value;
       }





    @Override
    public boolean containsAll(List<?> otherList) {
        for (int i =0 ; i < otherList.size() ;i++){
            Object value =  otherList.get(i);
            if(!contains((E) value)){
                return false;
            }
    }
        return true;
    }




    @Override
    public boolean addAll(int index, List<? extends E> otherList) {
        if( index < 0 || index >size){
            throw new IndexOutOfBoundsException("invalid index " + index);
        }
       int otherSize = otherList.size();
        if ( otherSize == 0 ){
            return false;
        }
        newArrray(size+otherSize);
        for (int i =size-1;i>=0;i++){
            element[i + otherSize]= element[i];
        }
        int newIndex = index;
        for( int i = 0 ; i < otherSize;i++){
            element[newIndex++]=(E)otherList.get(i);
        }
        size+=otherSize;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(get(i));
        }
        sb.append(']');
        return sb.toString();
    }
@Override
    public int hashCode(){
        int heshcode = 0;

    for(int i = 0 ; i < size;i++){
    E value = get(i);
    heshcode = value.hashCode();
}
return heshcode;

}

}
