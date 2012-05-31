package corvid.i18nhub.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="MESSAGE", 
       uniqueConstraints={@UniqueConstraint(name="UNIQUE_CONSTRAINT",
                                            columnNames={"bundleId", "messageKey", "languageCode"})})
public class MessageEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String key;
    
    private String value;
    
    private String languageCode;
    
    private BundleEntity bundle;    
    
    public MessageEntity() {
        super();
    }

    @Column(name="messageId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="messageKey")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Column(name="messageValue")
    public String getValue() {
        return value;
    }

    public void setValue(String message) {
        this.value = message;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
    
    @ManyToOne
    @JoinColumn(name="bundleId")
    public BundleEntity getBundle() {
        return bundle;
    }

    public void setBundle(BundleEntity bundle) {
        this.bundle = bundle;
    }
}
