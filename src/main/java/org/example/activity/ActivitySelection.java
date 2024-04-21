package org.example.activity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ActivitySelection {
    public void selectActivity(List<Activity> list) {
        List<Activity> activityList = list.stream()
                .sorted((f1, f2) -> {
                    int compareResult = Integer.compare(f2.sum, f1.sum);
                    if (compareResult == 0) {
                        return Integer.compare(f1.finish, f2.finish);
                    }
                    return compareResult;
                })
                .toList();

        List<Activity> res = new ArrayList<>();
        print(activityList);

        System.out.println("------");
        Activity first = activityList.get(0);
        int lastTwo = first.finish;
        int firstTwo = first.start;
        int lastOne = 0;
        res.add(first);
        for (int i = 1; i < activityList.size(); i++) {
            if (activityList.get(i).sum == 2 && activityList.get(i).start >= lastTwo) {
                lastTwo = activityList.get(i).finish;
                res.add(activityList.get(i));
            } else {
                if (activityList.get(i).sum == 1 && activityList.get(i).finish <= firstTwo
                        && activityList.get(i).start >= lastOne) {
                    lastOne = activityList.get(i).finish;
                    res.add(activityList.get(i));
                }
            }
        }
        res.sort(Comparator.comparingInt(f -> f.finish));
        print(res);
    }

    private void print(List<Activity> list) {
        for (Activity e : list) {
            System.out.println(e.name + "  " + e.start + " -> " + e.finish + " " + e.sum);
        }
    }
}

