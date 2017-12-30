package pers.landriesnidis.ecc.bean;

/**
 * Created by landriesnidis on 17-12-22.
 */
public class DeveloperBean {
    private String developerEmail;
    private String developerPhone;
    private int developerIndustry;

    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }

    public String getDeveloperPhone() {
        return developerPhone;
    }

    public void setDeveloperPhone(String developerPhone) {
        this.developerPhone = developerPhone;
    }

    public int getDeveloperIndustry() {
        return developerIndustry;
    }

    public void setDeveloperIndustry(int developerIndustry) {
        this.developerIndustry = developerIndustry;
    }

    @Override
    public String toString() {
        return developerEmail;
    }
}
