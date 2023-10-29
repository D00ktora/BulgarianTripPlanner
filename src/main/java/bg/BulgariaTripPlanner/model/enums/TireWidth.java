package bg.BulgariaTripPlanner.model.enums;

public enum TireWidth {
    TWO(2),
    TWO_TWENTY_FIVE(2.25),
    // ...
    TWO_THREE(2.3),
    TWO_FIVE(2.5),
    TWO__SEVEN_FIVE(2.75),
    THREE(3),
    THREE_TWO_FIVE(3.25),
    THREE_FIVE(3.5),
    FOUR(4),
    FOUR_ONE(4.1),
    FOUR_FIVE(4.5),
    FOUR_SIX(4.6),
    FIVE_ONE(5.1),
    NINETEEN(19),
    TWENTY(20),
    TWENTY_ONE(21),
    TWENTY_TWO(22),
    TWENTY_FIVE(25),
    TWENTY_SIX(26),
    TWENTY_SEVEN(27),
    TWENTY_EIGHT(28),
    TWENTY_NINE(29),
    THIRTY(30),
    THIRTY_TWO(32),
    SIXTY(60),
    SEVENTY(70),
    EIGHTY(80),
    NINETY(90),
    HUNDRED(100),
    HUNDRED_TEN(110),
    HUNDRED_FIFTEEN(115),
    HUNDRED_TWENTY(120),
    HUNDRED_TWENTY_FIVE(125),
    HUNDRED_THIRTY(130),
    HUNDRED_FORTY(140),
    HUNDRED_FIFTY(150),
    HUNDRED_SIXTY(160),
    HUNDRED_SIXTY_FIVE(165),
    HUNDRED_SEVENTY(170),
    HUNDRED_EIGHTY(180),
    HUNDRED_NINETY(190),
    TWO_HUNDRED(200),
    TWO_HUNDRED_TEN(210),
    TWO_HUNDRED_FORTY(240),
    TWO_HUNDRED_FIFTY(250),
    TWO_HUNDRED_SIXTY(260),
    TWO_HUNDRED_SEVENTY(270),
    TWO_HUNDRED_SEVENTY_FIVE(275),
    TWO_HUNDRED_EIGHTY(280),
    THREE_HUNDRED(300),
    THREE_HUNDRED_TWENTY_FIVE(325),
    THREE_HUNDRED_FIFTY(350),
    FOUR_HUNDRED(400),
    FOUR_HUNDRED_TEN(410),
    FIFE_HUNDRED(500);

    public final double value;

    private TireWidth(double value) {
        this.value = value;
    }
    public double getNumVal() {
        return value;
    }
}
