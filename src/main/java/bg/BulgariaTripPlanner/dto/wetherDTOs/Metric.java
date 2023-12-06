package bg.BulgariaTripPlanner.dto.wetherDTOs;

public class Metric {
    private int Value;
    private String Unit;
    private int UnitType;

    public int getValue() {
        return Value;
    }

    public Metric setValue(int value) {
        Value = value;
        return this;
    }

    public String getUnit() {
        return Unit;
    }

    public Metric setUnit(String unit) {
        Unit = unit;
        return this;
    }

    public int getUnitType() {
        return UnitType;
    }

    public Metric setUnitType(int unitType) {
        UnitType = unitType;
        return this;
    }
}
