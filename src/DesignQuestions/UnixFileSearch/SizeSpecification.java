package DesignQuestions.UnixFileSearch;

public class SizeSpecification implements Specification<File> {

    private long size;

   public SizeSpecification(long size){
       this.size = size;
   }

    @Override
    public boolean isSatisifiedBy(File item) {
        return item.getSize() == size;
    }
}
