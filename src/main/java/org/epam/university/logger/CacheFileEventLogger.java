package org.epam.university.logger;

import org.epam.university.domain.Event;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Kuzniatsou
 */
public class CacheFileEventLogger extends FileEventLogger {

    private File file;
    private String path;
    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String path, int cacheSize) {
        super(path);
        this.cacheSize = cacheSize;
    }

    public void logEvent(String message) {
        System.out.println(message);
    }

    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() throws IOException {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    private void destroy() throws IOException {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
