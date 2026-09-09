package ar.edu.undec.adapter.service.libro.beanconfig;

import libro.input.RegistrarLibroInput;
import libro.output.RegistrarLibroRepository;
import libro.usecase.RegistrarLibroUseCase;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public RegistrarLibroInput registrarLibroInput(RegistrarLibroRepository registrarLibroRepository){
        return new RegistrarLibroUseCase(registrarLibroRepository);
    }
}
