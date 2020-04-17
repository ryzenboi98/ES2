import com.controllers.CustomerController;
import com.customer.Customer;
import com.gateway.EmailGatewayStub;
import com.gateway.IEmailGateway;
import com.http.HttpResponseMessage;
import com.repository.ICustomerRepository;
import com.repository.Repository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailGWIntegration {
    @AfterAll
    static void TearDown() {
        End e = new End();
    }

    @Test
    public void testCustomerCreation() {

        IEmailGateway email = new EmailGatewayStub();
        int n = ((EmailGatewayStub) email).getSentEmails();
        ICustomerRepository repos = new Repository();
        CustomerController CostumerC = new CustomerController(repos, email);

        HttpResponseMessage response = CostumerC.createCustomer("John","john@gmail.com","Odense");
        Customer c_email = repos.getCustomerByEmail("john@gmail.com");
        assertEquals(c_email.getName(), "John");
        assertEquals(c_email.getCity(), "Odense");
        assertEquals(c_email.getEmail(), "john@gmail.com");

        assertEquals(n+1, ((EmailGatewayStub) email).getSentEmails());
        assertTrue(((EmailGatewayStub) email).getMessagesSent().contains("Hello Dear Customer"+c_email.getName()));
    }
}