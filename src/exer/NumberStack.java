package exer;

/**
 * @author bling
 * @create 2022-09-25 16:30
 */
@SuppressWarnings("unchecked")
public class NumberStack<T> {
    private int elementCount;//记录元素个数
    private int maxSize = 10;
    private Object[] elementData;

    public NumberStack() {
//        elementData = new Object[maxSize];
        this(10);
    }

    public NumberStack(int maxSize) {
        this.maxSize = maxSize;
        elementData = new Object[maxSize];
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return elementCount == 0;
    }

    /**
     * 判断栈是否已满
     */
    public boolean isFull() {
        return elementCount == maxSize;
    }

    /**
     * 添加元素
     */
    public void push(T element) {
        if (isFull()) {
            throw new RuntimeException("栈已满，添加失败");
        }
        elementData[elementCount++] = element;
    }

    /**
     * 元素出栈
     */
    public T pop() {
        if (isEmpty()) throw new RuntimeException("栈为空，无法出栈");
        T returnElement = (T)elementData[--elementCount];
        elementData[elementCount] = null;
        return returnElement;
    }

    /**
     * 查看栈顶元素
     */
    public T peek() {
        if (isEmpty()) return null;
        return (T)elementData[elementCount-1];
    }

    /**
     * 获取栈中所有元素
     */
    public void listAll() {
        for (int i = elementCount-1; i >=0 ; i--) {
            System.out.println(elementData[i]);
        }
    }

    /**
     * 查看栈中元素个数
     */
    public int size() {
        return elementCount;
    }
}
