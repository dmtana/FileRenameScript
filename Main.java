package FileRenameScript;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;


public class Main{
    public static void main(String[] args) throws Exception{
        Path path = Paths.get("C:\\Users\\Dmitry Kravchuk\\Desktop\\TEST_FILE_RENAME\\");
        Files.walkFileTree(path, new HashSet<FileVisitOption>(), 1, new MyFileVisitor());
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes) throws IOException {
        System.out.println(file.getFileName());
        /*
         * Rename File
         * if name contain "IMG_"
         * delete "IMG_" fromm name of file
         */
        if(file.getFileName().toString().contains("IMG_")){
            Files.move(file, Paths.get(file.toAbsolutePath().toString().replace("IMG_","")));
        }
        return FileVisitResult.CONTINUE;
    }
}