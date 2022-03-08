package Feb28.BugDetails;

import java.util.Date;

public class BugDetails {
    public enum EffectOfBug {
        Low, Medium, High
    }

    public int id;
    public String moduleName;
    public int testerId;
    public Date date;
    public EffectOfBug effectOfBug;

    public BugDetails(int id, String moduleName, int testerId, Date date, EffectOfBug effectOfBug) {
        this.id = id;
        this.moduleName = moduleName;
        this.testerId = testerId;
        this.date = date;
        this.effectOfBug = effectOfBug;

    }
}
