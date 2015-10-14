package org.epam.university.config;

import org.epam.university.domain.EventType;
import org.epam.university.logger.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrei Kuzniatsou
 */
@Configuration
public class LoggerConfig {

    @Bean
    public ConsoleEventLogger consoleEventLogger() {
        return new ConsoleEventLogger();
    }

    @Bean
    public FileEventLogger fileEventLogger() {
        return new FileEventLogger("d:/log.txt");
    }

    @Bean
    public CacheFileEventLogger cacheFileEventLogger() {
        return new CacheFileEventLogger("d:/cache_log.txt", 10);
    }

    @Bean
    public CombineEventLogger combineEventLogger() {
        return new CombineEventLogger(loggerList());
    }

    @Bean
    public List<IEventLogger> loggerList() {
        List<IEventLogger> loggers = new ArrayList<>();
        loggers.add(consoleEventLogger());
        loggers.add(fileEventLogger());
        return loggers;
    }

    @Bean
    public Map<EventType, IEventLogger> loggerMap() {
        Map<EventType, IEventLogger> loggers = new HashMap<>();
        loggers.put(EventType.INFO, consoleEventLogger());
        loggers.put(EventType.ERROR, combineEventLogger());
        return loggers;
    }
}
