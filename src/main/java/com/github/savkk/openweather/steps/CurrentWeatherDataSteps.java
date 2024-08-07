package com.github.savkk.openweather.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.openapitools.client.model.Model200;

import static com.github.savkk.openweather.clients.Clients.openWeatherClient;
import static org.apache.http.HttpStatus.SC_OK;

public class CurrentWeatherDataSteps {

    @Step
    public Model200 getWeatherDataWithDto(String city) {
        return openWeatherClient().currentWeatherData().qQuery(city)
                .executeAs(response -> response
                        .then()
                        .statusCode(SC_OK).extract().response());
    }

    @Step
    public ValidatableResponse getWeatherDataWithValidatableResponse(String city) {
        return openWeatherClient().currentWeatherData().qQuery(city)
                .execute(response -> response
                        .then()
                        .statusCode(SC_OK));
    }
}
