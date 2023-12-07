package bg.BulgariaTripPlanner.dto.wetherDTOs.forDay;

public class Temperature {
    private Minimum Minimum;
    private Maximum Maximum;

    public Minimum getMinimum() {
        return Minimum;
    }

    public Temperature setMinimum(Minimum minimum) {
        Minimum = minimum;
        return this;
    }

    public Maximum getMaximum() {
        return Maximum;
    }

    public Temperature setMaximum(Maximum maximum) {
        Maximum = maximum;
        return this;
    }
}
