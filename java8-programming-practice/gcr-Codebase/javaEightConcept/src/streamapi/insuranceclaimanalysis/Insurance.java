package streamapi.insuranceclaimanalysis;

public class Insurance {

    private int claimId;
    private String claimType;      // HEALTH, VEHICLE, LIFE, TRAVEL
    private double claimAmount;

    public Insurance(int claimId, String claimType, double claimAmount) {
        this.claimId = claimId;
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }

    // Getter for claim id
    public int getClaimId() {
        return claimId;
    }

    // Getter for claim type
    public String getClaimType() {
        return claimType;
    }

    // Getter for claim amount
    public double getClaimAmount() {
        return claimAmount;
    }

    @Override
    public String toString() {
        return "Insurance [claimId=" + claimId +
               ", claimType=" + claimType +
               ", claimAmount=" + claimAmount + "]";
    }
}
