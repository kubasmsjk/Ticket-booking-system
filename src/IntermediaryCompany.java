import java.util.Objects;
import java.io.*;

public class IntermediaryCompany implements Serializable{
    private String companyName;
    private String KRS;

    public IntermediaryCompany(String companyName, String KRS) {
        this.companyName = companyName;
        this.KRS = KRS;
    }

    public IntermediaryCompany() {
        companyName = "unknown";
        KRS = "0000000000";
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getKRS() {
        return KRS;
    }

    @Override
    public String toString() {
        return "IntermediaryCompany{" +
                "companyName='" + companyName + '\'' +
                ", KRS='" + KRS + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntermediaryCompany that = (IntermediaryCompany) o;
        return Objects.equals(companyName, that.companyName) && Objects.equals(KRS, that.KRS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, KRS);
    }
}
