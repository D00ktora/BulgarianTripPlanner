package bg.BulgariaTripPlanner.dto.wetherDTOs;

public class Elevation {
    private Metric Metric;
    private Imperial Imperial;

    public bg.BulgariaTripPlanner.dto.wetherDTOs.Metric getMetric() {
        return Metric;
    }

    public Elevation setMetric(bg.BulgariaTripPlanner.dto.wetherDTOs.Metric metric) {
        Metric = metric;
        return this;
    }

    public bg.BulgariaTripPlanner.dto.wetherDTOs.Imperial getImperial() {
        return Imperial;
    }

    public Elevation setImperial(bg.BulgariaTripPlanner.dto.wetherDTOs.Imperial imperial) {
        Imperial = imperial;
        return this;
    }
}
