package DesignQuestions.UnixFileSearch;



public class NameSpecification implements  Specification<File>{

    private String name;

    public  NameSpecification(String name){
        this.name = name;
    }
    @Override
    public boolean isSatisifiedBy(File item) {
        return item.getName().equalsIgnoreCase(name);
    }
}
