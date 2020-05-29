
import java.util.AbstractList;

public class DemoArrayListGet<E> extends AbstractList {
    private int size;

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    @Override
    public int size() {
        return size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+ index + ", Size: " + size;
    }

    E elementData(int index) {
        return elementData(index);
    }

}
