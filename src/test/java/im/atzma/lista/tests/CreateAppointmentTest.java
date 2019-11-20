package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

public class CreateAppointmentTest extends TestBase {

        public static void main (String [] args) {
            TestNG testng = new TestNG();
            List<String> suiteFiles=new ArrayList<String>();
            suiteFiles.add("im/atzma/lista/tests/testng-AppointmentCreation.xml");
            testng.setTestSuites(suiteFiles);
            testng.run();

            System.out.println("ddd");
        }

    @Test(priority = 1)
    public void testAppointmentCreation() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getAppointmentHelper().createAppointment();

        String expected = "[09:00 - 09:30, Temp Client katalon, Temp services_katalon, 30 דקות]";
        List<String> actual = app.getAppointmentHelper().verifyAppointmentCreation();
        try {
            Assert.assertEquals(actual.toString(), expected, "verify appointment creation");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 2)
    public void testAppointmentDeletion() throws InterruptedException {
        app.getAppointmentHelper().deleteAppointment();
        app.getCalendarPage().logout();
        app.getSessionHelper().loginWithUser();

//        try {
//            Assert.assertTrue(app.getAppointmentHelper().verifyAppointmentDeletion(), "verify appointment deletion");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
