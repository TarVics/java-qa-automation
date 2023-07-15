package base.core;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private LogType logType;

    @Step("MESSAGE {message}")
    private void log(String message){
        switch (logType) {
            case WARN -> logger.warn(message);
            case ERROR -> logger.error(message);
            default -> logger.info(message);
        }
    }
    protected void logInfo(String message, Object... args){
        logType = LogType.INFO;
        log(String.format(message, args));
    }
    private enum LogType {
        INFO, WARN, ERROR
    }
}
