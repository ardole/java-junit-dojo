package fr.dojo.service.mockito.mock;

import fr.dojo.exception.UserException;
import fr.dojo.model.User;
import fr.dojo.repository.UserRepository;
import fr.dojo.service.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceMockTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws UserException {
        MockitoAnnotations.initMocks(this);

        User alice = new User();
        alice.setPassword("1234");
        alice.setUserName("alice");

        User otherUser = new User();
        otherUser.setPassword("0000");
        otherUser.setUserName("doesnotmather");

        when(userRepository.findUser(anyString())).thenReturn(otherUser);

        when(userRepository.findUser("alice")).thenReturn(alice);
    }

    @Test
    public void changeUserPasswordWithMock() throws UserException {
        userService.changeUserPassword("alice", "2345678");

        verify(userRepository, times(1)).findUser("alice");
        verify(userRepository, times(1)).updatePassword("alice", "2345678");
    }

    @Test
    public void changeUserPasswordExceptionWithFake() throws UserException {
        expectedException.expect(UserException.class);
        expectedException.expectMessage("New password should be different from the old one !");

        userService.changeUserPassword("alice", "1234");
    }
}
