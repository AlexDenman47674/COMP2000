import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    @Test
    public void AdminTest()
    {
        Admin TestAdmin = new Admin();
        TestAdmin.setID("2");
        TestAdmin.setLoginName("TestAccount");
        TestAdmin.setPassword("TestPassword");

        assertNotNull(TestAdmin);
    }
}