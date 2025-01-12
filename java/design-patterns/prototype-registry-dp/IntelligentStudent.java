
public class IntelligentStudent extends Student {

    private int iq;
    private int intelligentScore;

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

}
