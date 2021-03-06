package ru.job4j.search;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("low", 5));
        priorityQueue.put(new Task("middle", 2));
        priorityQueue.put(new Task("low", 7));
        priorityQueue.put(new Task("hight", 1));
        priorityQueue.put(new Task("middle", 3));
        priorityQueue.put(new Task("urgent", 1));
        Task result = priorityQueue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenOnlyHigherPriorityThanGetLastUrgentTask() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("first", 1));
        priorityQueue.put(new Task("second", 1));
        priorityQueue.put(new Task("third", 1));
        Task result = priorityQueue.take();
        assertThat(result.getDesc(), is("third"));
    }

    @Test
    public void test() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("urgent", 1));
        priorityQueue.put(new Task("middle", 2));
//        priorityQueue.put(new Task("mid", 2));
//        priorityQueue.put(new Task("lowww", 7));
    }
}
