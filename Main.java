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
        Path path = Paths.get("E:\\Фотографии\\2019\\03 март 2019");
        Files.walkFileTree(path, new HashSet<FileVisitOption>(), 1, new MyFileVisitor());
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes) throws IOException {

        if(file.getFileName().toString().contains("IMG_")){
            Files.move(file, Paths.get(file.toAbsolutePath().toString().replace("IMG_","")));
        }
        if(file.getFileName().toString().contains("PANO_")){
            Files.move(file, Paths.get(file.toAbsolutePath().toString().replace("PANO_","")));
        }
        if(file.getFileName().toString().contains("VID_")){
            Files.move(file, Paths.get(file.toAbsolutePath().toString().replace("VID_","")));
        }
        return FileVisitResult.CONTINUE;
    }
}