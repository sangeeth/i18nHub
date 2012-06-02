package corvid.i18nhub.core.bean;

import java.io.Serializable;
import java.util.List;

public class BundleEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    public static class Translation implements Serializable {

        private static final long serialVersionUID = 1L;

        private String value;
        
        private String language;
        
        public Translation() {
            super();
        }
        
        public String getValue() {
            return value;
        }
        
        public void setValue(String value) {
            this.value = value;
        }
        
        public String getLanguage() {
            return language;
        }
        
        public void setLanguage(String language) {
            this.language = language;
        }
    }
    
    private String bundleName;
    
    private String key;
    
    private String value;
    
    private List<Translation> translations;

    public BundleEntry() {
        super();
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }
}
