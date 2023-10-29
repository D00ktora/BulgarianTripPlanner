package bg.BulgariaTripPlanner.model.enums;

public enum Diameter {
    ONE(1),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SIXTEEN_FIVE(16.5),
    SEVENTEEN(17),
    EIGHTEEN(18),
    NINETEEN(19),
    TWENTY_ONE(21),
    TWENTY_TREE(23),
    FOUR_HUNDRED_TWENTY(420);


    public final double value;

    private Diameter(double value) {
        this.value = value;
    }
    public double getNumVal() {
        return value;
    }
}
