package com.github.savkk.openweather.tests;

import com.github.savkk.openweather.steps.CurrentWeatherDataSteps;
import org.junit.jupiter.api.Test;
import org.openapitools.client.model.Model200;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CurrentWeatherDataTests {
    private final CurrentWeatherDataSteps currentWeatherDataSteps = new CurrentWeatherDataSteps();

    @Test
    void testCurrentWeatherDataWithDto() {
        Model200 response = currentWeatherDataSteps.getWeatherDataWithDto("Omsk");
        assertThat(response.getSys()).isNotNull();
        assertThat(response.getSys().getCountry()).isNotNull();
        assertThat(response.getSys().getCountry()).isEqualTo("RU");

    }

    @Test
    void testCurrentWeatherData() {
        currentWeatherDataSteps
                .getWeatherDataWithValidatableResponse("Innopolis")
                .assertThat()
                .body("sys.country", equalTo("RU"));
    }
}
