package DesignQuestions.UnixFileSearch;


import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        File file1 = new File("reports.txt", "txt", 1024, false);
        File file2 = new File("data.csv", "csv", 256, false);
        File Directory = new File("documents", "", 0, true);

        Directory.addChild(file1);
        Directory.addChild(file2);

        Specification<File> namespec = new NameSpecification("reports.txt");
        Specification<File> sizeSpec = new SizeSpecification(1024);

        List<File> nameResult = namespec.filter(List.of(Directory));
        List<File> sizeResult = sizeSpec.filter(List.of(Directory));

        Specification<File> andSepc = namespec.and(sizeSpec);
        List<File> andResult = andSepc.filter(List.of(Directory));


        System.out.println("Files matching Name");
        andResult.forEach(System.out::println);
    }
}
