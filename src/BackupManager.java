import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BackupManager {

    private static final String BACKUP_LOCATION_DIR = "backups";

    public void createBackup(File original) throws IOException {
        // TODO: figure out backup file name
        Files.copy(original.toPath(), new File(BACKUP_LOCATION_DIR + "/...").toPath());
    }


    public void createBackup(List<String> lines) throws IOException {
        File file = new File("ContactListAgenda.csv");
        File dir = new File("Backups");
        if (!file.exists()) {
            file.createNewFile();
        }

    }

    public void viewBackup() {

    }

    public void loadBackup() {

    }

    public void removeBackup() {

    }
}
