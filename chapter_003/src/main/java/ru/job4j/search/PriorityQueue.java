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

        int index = 0;
        for (Task element : tasksList) {
            index++;
            if (task.getPriority() <= element.getPriority()) {
                index = this.tasksList.indexOf(element);
                    break;
            }
        }
        this.tasksList.add(index, task);
        System.out.println(this.tasksList);

    }

    public Task take() {
        return this.tasksList.poll();
    }
}
