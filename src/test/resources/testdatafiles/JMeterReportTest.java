package testdatafiles;

import org.testng.annotations.Test;
import utils.JMeterAllureUtil;

public class JMeterReportTest {

    @Test
    public void attachJMeterReport() {
        JMeterAllureUtil.attachJMeterResults();
    }
}