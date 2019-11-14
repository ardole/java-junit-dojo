package fr.dojo.service.custom.spy;

import fr.dojo.exception.UserException;
import fr.dojo.service.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserServiceSpyTest {

    private UserService userService;
    private SpyUserRepository spyUserRepository;

    @Rule
    public ExpectedException expectedException =  ExpectedException.none();

    @Before
    public void setUp() {
        this.userService = new UserService();
        this.spyUserRepository = new SpyUserRepository();
        this.userService.setUserRepository(spyUserRepository);
    }

    @Test
    public void changeUserPasswordWithSpy() throws UserException {
        userService.changeUserPassword("alice", "2345678");

        assertEquals("2345678", spyUserRepository.getUpdatedPasswordValue());
        assertTrue(spyUserRepository.passwordHasBeenUpdated());
    }

    @Test
    public void changeUserPasswordExceptionWithFake() throws UserException {
        expectedException.expect(UserException.class);
        expectedException.expectMessage("New password should be different from the old one !");

        userService.changeUserPassword("alice", "1234");
    }

}