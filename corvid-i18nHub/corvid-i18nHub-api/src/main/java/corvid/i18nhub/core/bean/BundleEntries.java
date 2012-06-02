package corvid.i18nhub.core.bean;

import java.util.Collections;
import java.util.List;

import jay.data.AbstractPagedResult;

public class BundleEntries extends AbstractPagedResult<BundleEntry> {
    private static final long serialVersionUID = 1L;

    private List<BundleEntry> items;
    
    public BundleEntries() {
        super();
        this.items = Collections.emptyList();
    }
    
    public List<BundleEntry> getItems() {
        return this.items;
    }
    
    public void setItems(List<BundleEntry> items) {
        this.items = items;
    }
}
