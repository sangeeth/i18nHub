package corvid.i18nhub.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="BUNDLE", 
       uniqueConstraints={@UniqueConstraint(name="UNIQUE_CONSTRAINT",
                                            columnNames={"projectId", "bundleName"})})
public class BundleEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    
    private ProjectEntity project;
    
    private String bundleName;
    
    private List<MessageEntity> messages;

    public BundleEntity() {
        super();
    }
    
    @Column(name="bundleId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy="bundle", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

    @ManyToOne
    @JoinColumn(name="projectId")
    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }
}
