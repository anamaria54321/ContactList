import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackupManager {

    private static final String BACKUP_LOCATION_DIR = "backups";
    private static final String BACKUP_EXT = ".bak";
    private static final DateFormat dateFormat = new SimpleDateFormat("-dd_MM_yyyy-hh:mm:ss");
    private File backupDir = new File(BACKUP_LOCATION_DIR);


    public BackupManager() {
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }
    }

    public Path createBackup(File original) throws IOException {
        // TODO: figure out backup file name

        String pathName = "/contactListAgenda";

//        String baseName = pathName.substring(0, pathName.lastIndexOf("."));
//        String extension = pathName.substring(pathName.lastIndexOf("."));

        return (Files.copy(original.toPath(), new File(BACKUP_LOCATION_DIR + pathName
                + new Date().getTime() + BACKUP_EXT).toPath()));

    }


//    public void createBackup(List<String> lines) throws IOException {
//        File fileName = new File("ContactListAgenda.csv");
//        File dirName = new File("Backups");
//        if (!fileName.exists()) {
//            fileName.createNewFile();
//        }
//
//    }

    public void viewBackup() {
        String[] paths = backupDir.list();
        for (String path : paths) {
            System.out.println(path);
        }
//        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
    }

    public void loadBackup() {
//        se citeste un backup si se rescrie fisierul ListContact.txt deoarece am pierdut ceva informatii
// https://stackoverflow.com/questions/10824027/get-the-metadata-of-a-file
    }

    public void removeBackup() {
//////////////jjjjjjj
    }
}
