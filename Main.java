import java.nio.file.*;
import java.io.*;
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
        /**
         * Rename File Algorithm
         */
        if(file.getFileName().toString().contains("IMG_")){

            String fileName = file.getFileName().toString();
            String newFileName = fileName.substring(4, fileName.length());
            String filePath = file.toAbsolutePath().toString();

            StringBuilder SBfilePath = new StringBuilder(filePath);
            SBfilePath.delete(filePath.length()-fileName.length(), filePath.length());
            SBfilePath.append(newFileName);

            String newFilePath = SBfilePath.toString();

            Files.move(file, Paths.get(newFilePath));
        }
        return FileVisitResult.CONTINUE;
    }
}