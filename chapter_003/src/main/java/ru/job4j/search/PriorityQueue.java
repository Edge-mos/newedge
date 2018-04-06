package ru.job4j.search;

import java.util.LinkedList;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */

public class PriorityQueue {
    private LinkedList<Task> tasksList = new LinkedList<>();

    public void put(Task task) {
        if (task.getPriority() != 1 || this.tasksList.isEmpty()) {
            this.tasksList.add(task);
        } else {
            this.tasksList.add(0, task);
        }
    }

    public Task take() {
        return this.tasksList.poll();
    }
}
