package poi.student.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/6
 **/
public class StudentServiceImplTest {
    ApplicationContext application;

    @Before
    public void setUp() throws Exception {
        application = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-*.xml"
        );
    }

    byte a;
    int b;
    float c;
    short d;
    long e;
    double f;
    char g;
    boolean h;
    String str ;
    @Test
    public void test1() {

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println("str  + " + str);

    }

}