package com.project.examenapiweb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Clase para la HISTORIA D - Configurar el límite de aviso low-Stock
 */
@Component
@ConfigurationProperties(prefix = "item")
public class ItemConfig {

    @Getter
    @Setter
    private Integer minStock;
}
