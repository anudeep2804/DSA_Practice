package DesignQuestions.UnixFileSearch;

import java.util.ArrayList;
import java.util.List;

// core Entity class this implies how every individual file properties look like

public class File {

   private String name;
   private String extension;
   private long size;
   private boolean isDirectory;
   private List<File> children;

   public  File (String name, String extension, long size, boolean isDirectory){
       this.name=name;
       this.isDirectory = isDirectory;
       this.size = size;
       this.extension = extension;
       this.children = isDirectory ?  new ArrayList<>() : null;
   }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public long getSize() {
        return size;
    }

    public List<File> getChildren() {
        return children;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public  void addChild(File file) throws Exception {
       if(isDirectory){
           children.add(file);
       }
       else {
           throw new Exception("Not a directory");
       }
    }

    @Override
    public String toString() {
        return "File  " + name



                ;
    }
}
