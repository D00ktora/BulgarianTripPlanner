package bg.BulgariaTripPlanner.model.enums.models;

public enum Australian {
    FC("F.C."),
    Blake("Blake"),
    NSW("NSW"),
    BologneElk("Bologne Elk"),
    FNR("FNR"),
    Sampson("Sampson");


    private String value;

    private Australian(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
