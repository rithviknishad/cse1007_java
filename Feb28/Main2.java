package Feb28;

import Feb28.TesterDetails.TesterDetails;
import Feb28.BugDetails.BugDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main2 {
    static List<TesterDetails> testers = new ArrayList<>();
    static List<BugDetails> bugs = new ArrayList<>();

    public static int avgNumberOfBugsIdentifiedByTesterIn2004(int testerId) {
        int count = 0;
        for (BugDetails bug : bugs)
            if (bug.testerId == testerId && bug.date.getYear() == 2004)
                count++;
        return count;
    }

    public static void displayAllTesterDetailsWhoseNameNotStartedWith(String prefix) {
        for (TesterDetails tester : testers)
            if (!tester.name.startsWith(prefix))
                tester.display();
    }

    public static int numberOfBugsIdentifiedInMonthOf(int month) {
        int count = 0;
        for (BugDetails bug : bugs)
            if (bug.date.getMonth() == month)
                count++;
        return count;
    }

    public static void main(String[] args) {
        testers.add(new TesterDetails(1, "AM", "Testter", "C++"));
        testers.add(new TesterDetails(2, "MA", "Testter", "C++"));
        testers.add(new TesterDetails(3, "KB", "Testter", "C++"));
        testers.add(new TesterDetails(4, "RN", "Testter", "C++"));

        bugs.add(new BugDetails(1, "python", 1, new Date(2004, 6, 12), BugDetails.EffectOfBug.High));
        bugs.add(new BugDetails(2, "python", 2, new Date(2004, 6, 13), BugDetails.EffectOfBug.High));
        bugs.add(new BugDetails(3, "python", 4, new Date(2005, 6, 12), BugDetails.EffectOfBug.High));

        System.out.println(avgNumberOfBugsIdentifiedByTesterIn2004(1));
        displayAllTesterDetailsWhoseNameNotStartedWith("MA");
        System.out.println(numberOfBugsIdentifiedInMonthOf(6));

    }
}
