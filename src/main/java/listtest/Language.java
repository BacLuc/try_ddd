package listtest;

/**
 * Created by lucius on 12.05.17.
 */
public class Language {
    private String name;

    public Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object otherlanguage){
        if(otherlanguage instanceof Language){
            return ((Language)otherlanguage).getName().equals(getName());
        }
        return false;
    }

    public int hashCode(){
        return getClass().getName().concat(getName()).hashCode();
    }

    public String toString(){
        return getName();
    }
}
