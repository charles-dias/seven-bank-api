package com.charles.sevenbankapi.configuration;

import java.util.concurrent.Executors;

import org.apache.coyote.AbstractProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VirtualThreadTomcatConfig
        implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(connector -> {
            var handler = connector.getProtocolHandler();
            if (handler instanceof AbstractProtocol<?> protocol) {
                // executor de virtual threads
                protocol.setExecutor(Executors.newVirtualThreadPerTaskExecutor());

                protocol.setMaxConnections(1_000);
                connector.setProperty("acceptCount", "1000");  // backlog de 1000
            }
        });
    }
}


