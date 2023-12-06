package bg.BulgariaTripPlanner.dto.wetherDTOs;

public class Imperial {
    private int Value;
    private String Unit;
    private int UnitType;

    public int getValue() {
        return Value;
    }

    public Imperial setValue(int value) {
        Value = value;
        return this;
    }

    public String getUnit() {
        return Unit;
    }

    public Imperial setUnit(String unit) {
        Unit = unit;
        return this;
    }

    public int getUnitType() {
        return UnitType;
    }

    public Imperial setUnitType(int unitType) {
        UnitType = unitType;
        return this;
    }
}
