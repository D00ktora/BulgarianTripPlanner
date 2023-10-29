package bg.BulgariaTripPlanner.model.enums;

public enum Height {
    FOUR(4),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    THIRTY_FIVE(35),
    FORTY_FIVE(45),
    FIFTY(50),
    FIFTY_FIVE(55),
    SIXTY(60),
    SIXTY_FIVE(65),
    SEVENTY(70),
    SEVENTY_FIVE(75),
    EIGHTY(80),
    EIGHTY_FIVE(85),
    NINETY(90),
    HUNDRED(100),
    SIX_HUNDRED(600);

    public final int value;

    private Height(int value) {
        this.value = value;
    }
    public int getNumVal() {
        return value;
    }
}
