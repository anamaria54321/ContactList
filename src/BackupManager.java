import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BackupManager {

    private static final String BACKUP_LOCATION_DIR = "backups";
    private static final DateFormat dateFormat = new SimpleDateFormat("-dd_MM_yyyy-hh:mm:ss.");

    public void createBackup(File original) throws IOException {
        // TODO: figure out backup file name
        String pathName = "/contactListAgenda.csv";


        String baseName = pathName.substring(0, pathName.lastIndexOf("."));
        String extension = pathName.substring(pathName.lastIndexOf("."));

        Files.copy(original.toPath(), new File(BACKUP_LOCATION_DIR + baseName
                + dateFormat.format(new Date()) + extension).toPath());
    }


    public void createBackup(List<String> lines) throws IOException {
        File fileName = new File("ContactListAgenda.csv");
        File dirName = new File("Backups");
        if (!fileName.exists()) {
            fileName.createNewFile();
        }

    }

    public void viewBackup() {

    }

    public void loadBackup() {

    }

    public void removeBackup() {
//////////////jjjjjjj
    }
}
