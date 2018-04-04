package ru.job4j.search;

import java.util.LinkedList;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */

public class PriorityQueue {
    private LinkedList<Task> tasksList = new LinkedList<>();

    public LinkedList<Task> getTasksList() {
        return tasksList;
    }

    public void put(Task task) {
        if (this.tasksList.isEmpty()) {
            this.tasksList.add(task);
            return;
        }

        if (task.getPriority() == 1) {
            this.tasksList.add(0, task);
        }

        if (task.getPriority() > 1 && task.getPriority() <= 3) {
            int indexMiddle = 0;
            for (Task taskInList : tasksList) {
                if (taskInList.getPriority() == 1) {
                    indexMiddle++;
                } else {
                    break;
                }
            }
            this.tasksList.add(indexMiddle, task);
        }

        if (task.getPriority() > 3) {
            this.tasksList.add(task);
        }
    }

    public Task take() {
        return this.tasksList.poll();
    }
}
