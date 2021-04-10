import biz.Calkulator;
import org.junit.*;

public class CalkulatorTest {

    private Calkulator cal;

    @BeforeClass
    public static void bc(){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public static void ac(){
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() throws Exception {

        System.out.println("Before");
        cal = new Calkulator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After");
    }

    @Test
    public void add() {
        System.out.println("add测试");
        Assert.assertEquals(3,cal.add(2,1));
    }

    @Test
    public void sub() {
        System.out.println("sub");
        Assert.assertEquals(1,cal.sub(2,1));
    }
}