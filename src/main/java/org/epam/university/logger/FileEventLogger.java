package org.epam.university.logger;

import org.apache.commons.io.FileUtils;
import org.epam.university.domain.Event;

import java.io.File;
import java.io.IOException;

/**
 * @author Andrei Kuzniatsou
 */
public class FileEventLogger implements IEventLogger {

    private File file;
    private String path;

    private void init() {
        this.file = new File(path);
    }

    public FileEventLogger(String path) {
        this.path = path;
    }

    public void logEvent(String message) {
        System.out.println(message);
    }

    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(file, event.toString(), true);
        FileUtils.writeStringToFile(file, "\n", true);
    }
}
