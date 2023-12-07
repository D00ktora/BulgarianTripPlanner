package bg.BulgariaTripPlanner.dto.wetherDTOs.forKey;


import java.util.List;

public class SupplementalAdminAreas {
    private List<Suplement> suplements;

    public List<Suplement> getSuplements() {
        return suplements;
    }

    public SupplementalAdminAreas setSuplements(List<Suplement> suplements) {
        this.suplements = suplements;
        return this;
    }
}
