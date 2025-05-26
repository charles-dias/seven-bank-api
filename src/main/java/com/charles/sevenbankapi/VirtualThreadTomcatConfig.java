package com.charles.sevenbankapi;

import java.util.concurrent.Executors;

import org.apache.coyote.ProtocolHandler;
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

                // aumentar o número máximo de conexões simultâneas e backlog
                protocol.setMaxConnections(1_000);   // aceita até 1000 conexões ativas
                connector.setProperty("acceptCount", "1000");  // backlog de 1000
            }
        });
    }
}


