package bg.BulgariaTripPlanner.dto.wetherDTOs.forDay;

public class Minimum {
    private double Value;
    private String Unit;
    private int UnitType;

    public double getValue() {
        return Value;
    }

    public Minimum setValue(double value) {
        Value = value;
        return this;
    }

    public String getUnit() {
        return Unit;
    }

    public Minimum setUnit(String unit) {
        Unit = unit;
        return this;
    }

    public int getUnitType() {
        return UnitType;
    }

    public Minimum setUnitType(int unitType) {
        UnitType = unitType;
        return this;
    }
}
