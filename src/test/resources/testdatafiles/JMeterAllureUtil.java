package testdatafiles;

import io.qameta.allure.Attachment;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JMeterAllureUtil {

    @Attachment(value = "JMeter Results", type = "text/csv")
    public static byte[] attachJMeterResults() {
        try {
            return Files.readAllBytes(
                    Paths.get("target/jmeter/results/reqres_test.csv")
            );
        } catch (Exception e) {
            return null;
        }
    }
}