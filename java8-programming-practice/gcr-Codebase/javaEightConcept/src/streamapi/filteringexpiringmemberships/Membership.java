package streamapi.filteringexpiringmemberships;

import java.time.LocalDate;

public class Membership {

    private int memberId;
    private String memberName;
    private LocalDate expiryDate;

    public Membership(int memberId, String memberName, LocalDate expiryDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.expiryDate = expiryDate;
    }

    // Getter for member id
    public int getMemberId() {
        return memberId;
    }

    // Getter for member name
    public String getMemberName() {
        return memberName;
    }

    // Getter for membership expiry date
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Membership [memberId=" + memberId +
               ", memberName=" + memberName +
               ", expiryDate=" + expiryDate + "]";
    }
}
