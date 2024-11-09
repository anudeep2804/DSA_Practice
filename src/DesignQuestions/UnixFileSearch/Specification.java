package DesignQuestions.UnixFileSearch;

import java.util.ArrayList;
import java.util.List;

public interface Specification<T> {

    boolean isSatisifiedBy(T item);

    default List<T> filter (List<T> items){

        List<T> result = new ArrayList<>();

        for(T item : items){
            if (item instanceof File file) {

                if(file.isDirectory()){
                    result.addAll(filter((List<T>) file.getChildren()));
                }
                else if (isSatisifiedBy(item)){
                    result.add(item);
                }
            }
        }

        return result;
    }

    default AndSpecification and (Specification<T> other){
        return new AndSpecification((Specification<File>) this, (Specification<File>) other);
    }
}
