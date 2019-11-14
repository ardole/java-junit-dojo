package fr.dojo.service.custom.stub;

import fr.dojo.exception.UserException;
import fr.dojo.service.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserServiceStubTest {

    private UserService userService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        this.userService = new UserService();
        this.userService.setUserRepository(new StubUserRepository());
    }

    @Test
    public void changeUserPasswordWithFake() throws UserException {
        userService.changeUserPassword("alice", "2345678");
    }

    @Test
    public void changeUserPasswordExceptionWithFake() throws UserException {
        expectedException.expect(UserException.class);
        expectedException.expectMessage("New password should be different from the old one !");

        userService.changeUserPassword("alice", "1234");
    }

}