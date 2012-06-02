package corvid.i18nhub.core.bean;

import jay.util.DataBean;

public class User extends DataBean {
    private static final long serialVersionUID = 1L;

    private String name;

    private String emailAddress;

    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
