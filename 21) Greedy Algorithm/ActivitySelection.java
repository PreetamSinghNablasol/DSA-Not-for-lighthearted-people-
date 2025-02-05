import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class ActivitySelection {
    public static void main(String[] args) {
        ArrayList<Activity> activityList = new ArrayList<Activity>();
        activityList.add(new Activity("A1", 4, 6));
        activityList.add(new Activity("A2", 3, 8));
        activityList.add(new Activity("A3", 9, 10));
        activityList.add(new Activity("A4", 3, 10));

        AlgoxClass.activitySelection(activityList);
    }
}

class Activity { // the activity :) XotiX
    private String name;
    private int startTime;
    private int finishTime;

    public Activity(String name, int startTime, int finishTime) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "| Activity : " + this.name + " | " + "StartTime : " + this.startTime + " | " + "FinishTime : "
                + this.finishTime + " |";
    }

}

class AlgoxClass {
    static void activitySelection(ArrayList<Activity> activityList) {
        Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getFinishTime() - o2.getFinishTime();
            }
        };
        Collections.sort(activityList, finishTimeComparator);
        Activity previousActivity = activityList.get(0);

        // in the below line note that the first element when sorted based on end time
        // will always be the first element of the optimal order for the Activity
        // selection problem
        System.out.println("\n\nRecomended Schedule :\n" + activityList.get(0));
        for (int i = 1; i < activityList.size(); i++) {
            Activity activity = activityList.get(i);
            if (activity.getStartTime() >= previousActivity.getFinishTime()) {
                System.out.println(activity);
                previousActivity = activity;
            }
        }
    }
}



