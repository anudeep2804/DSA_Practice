package DesignQuestions.UnixFileSearch;

public class AndSpecification implements Specification<File> {

    private Specification<File> first;
    private Specification<File> second;

    public <T> AndSpecification(Specification<File> first, Specification<File> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisifiedBy(File item) {
        return first.isSatisifiedBy(item) && second.isSatisifiedBy(item);
    }
}
