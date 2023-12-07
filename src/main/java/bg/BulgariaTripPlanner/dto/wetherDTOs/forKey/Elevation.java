package bg.BulgariaTripPlanner.dto.wetherDTOs.forKey;


public class Elevation {
    private Metric Metric;
    private Imperial Imperial;

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Metric getMetric() {
        return Metric;
    }

    public Elevation setMetric(bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Metric metric) {
        Metric = metric;
        return this;
    }

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Imperial getImperial() {
        return Imperial;
    }

    public Elevation setImperial(bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Imperial imperial) {
        Imperial = imperial;
        return this;
    }
}
