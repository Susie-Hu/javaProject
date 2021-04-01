package org.example;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;


public class mockito {

    @Test
    public void test(){
// mock creation
        List mockedList = mock(List.class);
// using mock object - it does not throw any "unexpected interaction" exception
        when(mockedList.get(0)).thenReturn("one");
        when(mockedList.get(1)).thenReturn("two");
// selective, explicit, highly readable verification
        mockedList.add("one");
        mockedList.clear();
//        do not need to verify every interaction
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void testInOrder(){
        List one = mock(List.class);
        List two = mock(List.class);

        InOrder inOrder = inOrder(one, two);
        one.add("one");
        two.add("two");

        inOrder.verify(one).add("one");
        inOrder.verify(two).add("two");

    }

}
