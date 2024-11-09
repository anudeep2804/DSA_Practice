package DesignQuestions.UnixFileSearch;


public class ExtensionSpecification implements  Specification<File>{

    private String extension;

    public  ExtensionSpecification(String extension){
        this.extension = extension;
    }
    @Override
    public boolean isSatisifiedBy(File item) {
        return item.getExtension().equalsIgnoreCase(extension);
    }
}
