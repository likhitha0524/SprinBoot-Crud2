package org.brillio.com.brillio.product.pact.provider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.loader.PactUrl;
import au.com.dius.pact.provider.junit5.HttpsTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Provider("productService")
@PactFolder("C:/Reece-Poc/com.brillio.product/src/test/java/org/brillio/com/brillio/product/pact/provider/pacts/order-service-productService.json")
public class PactProviderTest {

    @LocalServerPort
    public int port;

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    public void pactVerificationTest(PactVerificationContext context){
        context.verifyInteraction();
    }

    @BeforeEach
    public void setUp(PactVerificationContext context){
        context.setTarget(new HttpsTestTarget("localhost",port));
    }
}
