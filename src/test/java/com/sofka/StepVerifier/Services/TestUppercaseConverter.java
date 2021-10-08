package com.sofka.StepVerifier.Services;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

@SpringBootTest
public class TestUppercaseConverter {
    final TestPublisher<String> testPublisher = TestPublisher.create();


    @Test
    void testUpperCase() {
        UppercaseConverter uppercaseConverter = new UppercaseConverter(testPublisher.flux());
        StepVerifier.create(uppercaseConverter.getUpperCase())
                .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERADOS", "SOFKA")
                .verifyComplete();
    }
    @Test
    void testUpperCaseError() {

        TestPublisher<String> testPublishr = TestPublisher
                .createNoncompliant(TestPublisher.Violation.ALLOW_NULL);

        StepVerifier.create( testPublishr)
                .then(()-> testPublishr
                        .emit("1", "2", null, "3"))
                .expectNext("1", "2", null, "3")
                .expectComplete()
                .verify();
    }
}
