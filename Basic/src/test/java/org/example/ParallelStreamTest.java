package org.example;/**
 * TODO
 *
 * @author husi
 * @since 11/20/2020
 */

import static org.junit.Assert.assertTrue;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName ParallelStreamTest
 * @Description TODO
 * @Date 11/20/2020 11:14 AM
 * @Version 1.0
 **/
public class ParallelStreamTest {

    class Item {
        private Integer id;

        Item(Integer id) {
            this.id = id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }
    }

    @Before
    public void setup(){
        System.out.println("start at : " + new Date());
    }

    @After
    public void tearDown(){
        System.out.println("end at : " + new Date());
    }

//    count 1000000; sleep 1; pass
//    count 10;sleep 1000 * 60 * 2; pass
    @Test
    public void test() {
        List<Item> input = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        int count = 10;

        IntStream.range(0, count).forEach(x -> input.add(new Item(x)));

        CountDownLatch countDownLatch = new CountDownLatch(count);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 100, 120, TimeUnit.MINUTES, new LinkedBlockingDeque<>());

        IntStream.range(0, count).forEach(i -> {
//            System.out.println("Start to process " + i);
            Optional<Item> optional = input.parallelStream().filter(item -> (item.getId().equals(i))).findAny();
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    if (optional.isPresent()) {
                        try {
                            assertTrue(optional.get().getId().equals(i));
//                            System.out.println(Thread.currentThread().getName() + ":" + i);
                            Thread.currentThread().sleep(2*60*1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            countDownLatch.countDown();
                        }
                    }
                }
            });


        });

        try {
            countDownLatch.await(10,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All done");
        threadPoolExecutor.shutdown();
    }

    @Test
    public void test_retry() {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }



    @Test
    public void test1(){
        class TreeNode{
            Integer val;
            TreeNode next;
            TreeNode(Integer val){
                this.val = val;
            }
        }

        TreeNode node1 =  new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node4  = new TreeNode(5);
        TreeNode node3 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        node3.next = node5;
        node1.next = node2;
        node2.next = node4;

        // insert
        TreeNode tmp = node2.next;
        node2.next = node3;
        node3.next = tmp;
//        exchange
        Integer node3val = node3.val;
        node3.val = node2.val;
        node2.val = node3val;



//        node2.val = node3.val;

        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }


    }
}
