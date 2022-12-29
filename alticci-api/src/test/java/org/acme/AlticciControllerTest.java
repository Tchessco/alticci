package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AlticciControllerTest {

    private int[] expectedResults = new int []{0,1,1,1,2,2,3,4,5,7,9};

    @Test
    public void testAlticciEndpoint() {
        given()
          .when().get("/alticci/0")
          .then()
             .statusCode(200)
                .body(is("{\"value\":0}"));
    }

    @RepeatedTest(11)
    public void testSequenceCalculation(RepetitionInfo repetitionInfo) {

        int indexValue = repetitionInfo.getCurrentRepetition()-1;

        String url = "/alticci/" + indexValue;
        String expectedResult = String.format("{\"value\":%d}", expectedResults[indexValue]);

        given()
                .when().get(url)
                .then()
                .statusCode(200)
                .body(is(expectedResult));
    }
}