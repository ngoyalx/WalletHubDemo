package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import utils.SeleniumHandles;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import static utils.SeleniumHandles.projectProperty;

/**
 * Created by ngoyal on 29/07/17.
 */
public class CustomListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestSuccess(ITestResult result) {
        String methodname=result.getName().toString().trim();
        System.out.println("Method name is " + methodname);
        SeleniumHandles.takescreenshot(methodname);
        saveImageAttach(methodname);
    }

    public void onTestFailure(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }


    @Attachment(value = "{0}", type = "image/png")
    public static byte[] saveImageAttach(String methodname) {
        byte[] res=null;
        try {
            BufferedImage image = ImageIO.read(new File((projectProperty.screenShotPath + methodname + ".png")));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            res=baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}
