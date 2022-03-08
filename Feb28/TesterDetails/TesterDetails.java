package Feb28.TesterDetails;

public class TesterDetails {
    public int id;
    public String name;
    public String qualification;
    public String experience;

    public TesterDetails(int id, String name, String qualification, String experience) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.experience = experience;
    }

    public void display() {
        System.out
                .println(id + ": " + name + " [Qualification: " + qualification + ", Experience: " + experience + "]");
    }
}
