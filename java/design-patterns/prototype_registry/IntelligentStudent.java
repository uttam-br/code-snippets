package prototype_registry;

public class IntelligentStudent extends Student {

    private int iq;
    private int intelligentScore;

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getIntelligentScore() {
        return intelligentScore;
    }

    public void setIntelligentScore(int intelligentScore) {
        this.intelligentScore = intelligentScore;
    }

    IntelligentStudent() {
    }

    IntelligentStudent(IntelligentStudent is) {
        super(is);
        this.iq = is.iq;
        this.intelligentScore = is.intelligentScore;
    }

    @Override
    public IntelligentStudent copy() {
        return new IntelligentStudent(this);
    }

    public void display() {
        System.out.println("I am intelligent student");
    }

}
