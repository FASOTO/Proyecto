package proyecto.odontologia.webapp.springboot_web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class imgconfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        //TIENEN QUE CREAR ESTA CARPETE EN LA RUTA ESPECIFICADA
        registry.addResourceHandler("/Recursos/**").addResourceLocations("file:/C:/Paciente/Recursos/");
    }

    

}
