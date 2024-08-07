package com.github.savkk.openweather.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:env.properties"
})
public interface EnvConfig extends Config {
    EnvConfig env = ConfigFactory.create(EnvConfig.class);

    @Key("base-uri")
    String baseUri();
}
