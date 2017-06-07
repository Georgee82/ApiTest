package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.authorization.AuthorizationBusinessLogicTest;
import test.authorization.AuthorizationFieldValidationTest;
import test.registration.RegistrationBusinessLogicTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	RegistrationBusinessLogicTest.class,
	AuthorizationBusinessLogicTest.class,
	AuthorizationFieldValidationTest.class
})
public class TestSuite {

}
