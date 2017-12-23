package pers.landriesnidis.ecc.bean;

/**
 * Created by landriesnidis on 17-12-22.
 */
public class UserBean {
    private String account_email;
    private String account_phone;
    private int account_industry;

    public String getAccount_email() {
        return account_email;
    }

    public void setAccount_email(String account_email) {
        this.account_email = account_email;
    }

    public String getAccount_phone() {
        return account_phone;
    }

    public void setAccount_phone(String account_phone) {
        this.account_phone = account_phone;
    }

    public int getAccount_industry() {
        return account_industry;
    }

    public void setAccount_industry(int account_industry) {
        this.account_industry = account_industry;
    }

    @Override
    public String toString() {
        return account_email;
    }
}
