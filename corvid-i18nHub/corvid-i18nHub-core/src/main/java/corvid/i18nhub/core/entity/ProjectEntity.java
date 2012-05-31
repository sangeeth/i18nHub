package corvid.i18nhub.core.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="PROJECT", 
       uniqueConstraints={@UniqueConstraint(name="UNIQUE_CONSTRAINT",
                                            columnNames={"name"})})
public class ProjectEntity extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String name;
    
    private String description;
    
    private List<BundleEntity> bundles;

    public ProjectEntity() {
        super();
    }

    @Column(name="projectId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy="project", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
    public List<BundleEntity> getBundles() {
        return bundles;
    }

    public void setBundles(List<BundleEntity> bundles) {
        this.bundles = bundles;
    }
}
