package fr.dojo.service.mockito.spy;

import fr.dojo.exception.UserException;
import fr.dojo.repository.UserRepository;
import fr.dojo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserServiceSpyTest {

    @InjectMocks
    private UserService userService;

    @Spy
    private UserRepository userRepository = new UserRepositoryImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserPasswordWithMock() throws UserException {
        userService.changeUserPassword("alice", "2345678");

        verify(userRepository, times(1)).findUser("alice");
        verify(userRepository, times(1)).updatePassword("alice", "2345678");

    }
}
