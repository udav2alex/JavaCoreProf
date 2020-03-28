package homework7;

public class TestClass {

    @BeforeSuite
    public void before() {
        System.out.println("before");
    }

    @Test(priority = 2)
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test(priority = 8)
    public void test3() {
        System.out.println("test3");
    }

    @AfterSuite
    public void after() {
        System.out.println("after");
    }
}
