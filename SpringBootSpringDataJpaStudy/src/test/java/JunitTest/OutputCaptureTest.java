package JunitTest;

import com.fanliyan.SpringDataTest.Application;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class OutputCaptureTest {

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    public void outputCaptureTest(){
        System.out.println("");
        System.out.println("Hello");
        System.out.println("HelloWorld");
        System.out.println("HelloWorld1");
        System.out.println("HelloWorld2");
        System.out.println("HelloWorld3");

        System.out.println(capture.toString());

        assertThat(capture.toString(), Matchers.containsString("HelloWorld"));
    }
}
