package com.github.savkk.openweather.clients;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.CurrentWeatherDataApi;

import static com.github.savkk.openweather.config.CredentialsConfig.credentials;
import static com.github.savkk.openweather.config.EnvConfig.env;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static org.openapitools.client.JacksonObjectMapper.jackson;

public final class Clients {
    private Clients() {
        throw new IllegalStateException("Utility class");
    }

    private static final CurrentWeatherDataApi currentWeatherDataApi =
            ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(() ->
                    new RequestSpecBuilder()
                            .setConfig(config()
                                    .objectMapperConfig(
                                            objectMapperConfig().defaultObjectMapper(jackson())))
                            .addFilter(new RequestLoggingFilter())
                            .addFilter(new ResponseLoggingFilter())
                            .addFilter(new AllureRestAssured())
                            .setContentType(ContentType.JSON)
                            .setUrlEncodingEnabled(false)
                            .addQueryParam("appid", credentials.apiKey())
                            .setBaseUri(env.baseUri()))
            ).currentWeatherData();

    public static CurrentWeatherDataApi openWeatherClient() {
        return currentWeatherDataApi;
    }
}
