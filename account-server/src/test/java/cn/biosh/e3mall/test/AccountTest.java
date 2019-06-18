package cn.biosh.e3mall.test;


import java.util.Arrays;
import java.util.EmptyStackException;
import org.junit.Test;

/**
 * @description
 * @date 2019/4/24
 */
public class AccountTest {

  @Test
  public void name() {
    String a = new String("sads");
    System.out.println(a.hashCode());
//    System.out.println(
//        EmailUtil.sendEmail("konglingbiao@haylion.cn", "test for email", "hello world!"));

  }


  public class MyStack<T> {
    private T[] elements;
    private int size = 0;

    private static final int INIT_CAPACITY = 16;

    public MyStack() {
      elements = (T[]) new Object[INIT_CAPACITY];
    }

    public void push(T elem) {
      ensureCapacity();
      elements[size++] = elem;
    }

    public T pop() {
      if(size == 0)
        throw new EmptyStackException();
      return elements[--size];
    }

    private void ensureCapacity() {
      if(elements.length == size) {
        elements = Arrays.copyOf(elements, 2 * size + 1);
      }
    }
  }

}
