package es.zed.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class WebConfig {

	@Bean
	public CorsWebFilter corsWebFilter() {
		// Crear una nueva configuración CORS
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("http://localhost:4200"); // Cambia por el origen correcto
		config.addAllowedMethod("*"); // Permite todos los métodos HTTP
		config.addAllowedHeader("*"); // Permite todos los encabezados
		config.setAllowCredentials(true); // Permite el envío de credenciales (cookies, etc.)

		// Registrar la configuración en un origen específico
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config); // Aplica la configuración a todas las rutas

		// Crear y devolver un CorsWebFilter con la configuración
		return new CorsWebFilter(source);
	}
}