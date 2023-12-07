package bg.BulgariaTripPlanner.dto.wetherDTOs.forDay;

public class Maximum {
    private double Value;
    private String Unit;
    private int UnitType;

    public double getValue() {
        return Value;
    }

    public Maximum setValue(double value) {
        Value = value;
        return this;
    }

    public String getUnit() {
        return Unit;
    }

    public Maximum setUnit(String unit) {
        Unit = unit;
        return this;
    }

    public int getUnitType() {
        return UnitType;
    }

    public Maximum setUnitType(int unitType) {
        UnitType = unitType;
        return this;
    }
}
