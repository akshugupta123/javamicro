package com.example.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Component
public class LoggingGateWayFilterFactory extends AbstractGatewayFilterFactory<LoggingGateWayFilterFactory.Config> {

    private final Logger logger = LoggerFactory.getLogger(LoggingGateWayFilterFactory.class);

    public LoggingGateWayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
    	
        return (exchange, chain) -> {

            if (config.isPreLogger()) {
                logger.info("pre GatewayFilter logging " + config.getBaseMessage());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    logger.info("post GatewayFilter logging " + config.getBaseMessage());
                }
            }));
        };
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
		public boolean isPreLogger() {
			// TODO Auto-generated method stub
			return false;
		}
		public String getBaseMessage() {
			// TODO Auto-generated method stub
			return null;
		}
		public boolean isPostLogger() {
			// TODO Auto-generated method stub
			return false;
		}
    }
}
