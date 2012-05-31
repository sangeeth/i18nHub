package corvid.i18nhub.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="DICTIONARY", 
       uniqueConstraints={@UniqueConstraint(name="UNIQUE_CONSTRAINT",
                                               columnNames={"sourceString", "sourceLocale"})})
public class DictionaryEntity extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    
    private String sourceString;
    
    private String sourceLocale;
    
    private String targetString;
    
    private String targetLocale;

    public DictionaryEntity() {
        super();
    }
    
    @Column(name="dictionaryId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceString() {
        return sourceString;
    }

    public void setSourceString(String sourceString) {
        this.sourceString = sourceString;
    }

    public String getSourceLocale() {
        return sourceLocale;
    }

    public void setSourceLocale(String sourceLocale) {
        this.sourceLocale = sourceLocale;
    }

    public String getTargetString() {
        return targetString;
    }

    public void setTargetString(String targetString) {
        this.targetString = targetString;
    }

    public String getTargetLocale() {
        return targetLocale;
    }

    public void setTargetLocale(String targetLocale) {
        this.targetLocale = targetLocale;
    }
}
