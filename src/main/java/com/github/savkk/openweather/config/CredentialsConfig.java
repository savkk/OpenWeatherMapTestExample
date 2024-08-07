package com.github.savkk.openweather.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:credentials.properties"
})
public interface CredentialsConfig extends Config {
    CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @Key("api-key")
    String apiKey();
}
