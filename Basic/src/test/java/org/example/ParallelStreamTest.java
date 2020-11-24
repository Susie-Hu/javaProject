package org.example;/**
 * TODO
 *
 * @author husi
 * @since 11/20/2020
 */

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.*;
import java.util.stream.IntStream;

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

    @Test
    public void test() {
        List<Item> input = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        int count = 10;

        IntStream.range(0, count).forEach(x -> input.add(new Item(x)));

        CountDownLatch countDownLatch = new CountDownLatch(count);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 100, 120, TimeUnit.MINUTES, new LinkedBlockingDeque<>());

        IntStream.range(0, count).forEach(i -> {
            System.out.println("Start to process " + i);
            Optional<Item> optional = input.parallelStream().filter(item -> (item.getId().equals(i))).findAny();
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    if (optional.isPresent()) {
                        try {
                            assertTrue(optional.get().getId().equals(i));
//                            System.out.println(Thread.currentThread().getName() + ":" + i);
                            Thread.currentThread().sleep(1000);
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
            countDownLatch.await();
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
}
