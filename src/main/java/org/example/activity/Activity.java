package org.example.activity;

public class Activity {
    String name;
    int start;
    int finish;
    int sum;

    public Activity(String name, int start, int finish) {
        this.name = name;
        this.start = start;
        this.finish = finish;
        this.sum = initActivitySum();
    }

    public Activity(String name, int start, int finish, int sum) {
        this.name = name;
        this.start = start;
        this.finish = finish;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private int initActivitySum() {
        int sumBeforeLunch = 0;
        int sumAfterLunch = 0;
        if (start < 13) {
            sumBeforeLunch = 13 - start;
        } else {
            sumAfterLunch = finish - start;
        }
        if (finish >= 13) {
            sumAfterLunch = finish - 13;
        } else {
            sumBeforeLunch = finish - start;
        }
        if (sumBeforeLunch > sumAfterLunch) {
            return 1;
        } else return 2;
    }
}

