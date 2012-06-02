package corvid.i18nhub.core.search;

import jay.data.AbstractSearchCriteria;

public class BundleSearchCriteria extends AbstractSearchCriteria {
    private static final long serialVersionUID = 1L;
    
    private String bundleName;
    
    public BundleSearchCriteria() {
        super();
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }
}
