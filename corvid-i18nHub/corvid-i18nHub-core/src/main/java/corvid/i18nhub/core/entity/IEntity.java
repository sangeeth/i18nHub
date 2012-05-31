package corvid.i18nhub.core.entity;

import jay.util.IAuditable;

public interface IEntity extends IAuditable {
    Long getId();
    
    void setId(Long id);
}
