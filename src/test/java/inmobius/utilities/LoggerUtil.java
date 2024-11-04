package inmobius.utilities;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LoggerUtil {

    @Step("{0}")
    public static void logConsoleMessage(String message) {
        System.out.println(message); // This logs to the console
        Allure.addAttachment("Log", message); // This adds the log to the Allure report
    }

    @Step("{0}")
    public static void logConsoleMessage(String stepName, String message) {
        System.out.println(stepName + ": " + message); // This logs to the console
        Allure.addAttachment(stepName, message); // This adds the log to the Allure report
    }

    public static void logText(String message) {
        InputStream stream = new ByteArrayInputStream(message.getBytes(StandardCharsets.UTF_8));
        Allure.addAttachment("Log", stream);
    }

    public static void logText(String name, String message) {
        InputStream stream = new ByteArrayInputStream(message.getBytes(StandardCharsets.UTF_8));
        Allure.addAttachment(name, stream);
    }
}