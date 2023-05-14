package es.dsrroma.school.springboot.reuniones;

import org.springframework.beans.factory.annotation.Value;

public class UnBean {

	@Value("${nombre}")
    private String nombre;
}
