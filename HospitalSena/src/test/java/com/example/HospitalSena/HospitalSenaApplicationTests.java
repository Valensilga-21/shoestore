package com.example.HospitalSena;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.sena.HospitalSena.HospitalSenaApplication;
import com.sena.HospitalSena.controller.medicoController;
import com.sena.HospitalSena.interfaceService.IMedicoService;
import com.sena.HospitalSena.models.medico;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = HospitalSenaApplication.class)
@Transactional

class HospitalSenaApplicationTests {

	// @Test
	// void contextLoads() {
	// }
	//1. LOS DATOS DE ENTRADA
	//2.Cual es la salida esperada
	//3.Cual es la salida obtenida
	//4.Comparar las dos salidas
	
	@Test
	void testSuma() {
		int num1=5;
		int num2=3;
		int resultadoObtenido=num1+num2;
		int resultadoEsperado=8;
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Autowired
	private medicoController medicoController;

	@MockBean
	private IMedicoService medicoService;

	@Test
public void testMedicoCorrectoGuardar() {
	medico medico = new medico();
	medico.setDoc_medico("1234567890");
	medico.setPrimer_nombre_medico("Carolina");
	medico.setPrimer_apellido_medico("Giraldo");
	medico.setCorreo_medico("torruiz@gmail.com");
	medico.setTelefono_medico("3548697535");
	ResponseEntity<Object> response = medicoController.save(medico);
	assertEquals(HttpStatus.OK, response.getStatusCode());

}

@Test//error testing comprobar api
public void testMedicoIncompletoGuardar() {
	medico medico = new medico();
	medico.setDoc_medico("");
	medico.setPrimer_nombre_medico("Carolina");
	medico.setPrimer_apellido_medico("Giraldo");
	medico.setCorreo_medico("torruiz@gmail.com");
	medico.setTelefono_medico("3548697535");
	ResponseEntity<Object> response = medicoController.save(medico);
	assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
}

@Test//error testing comprobar api
public void testMedicoRepetidoGuardar() {
	medico medico = new medico();
	medico.setDoc_medico("123456789");
	medico.setPrimer_nombre_medico("Carolina");
	medico.setPrimer_apellido_medico("Giraldo");
	medico.setCorreo_medico("torruiz@gmail.com");
	medico.setTelefono_medico("3548697535");
	 
	 

	  List<medico> meidicos = new ArrayList<>();
	  meidicos.add(medico);
        

        // Simular el comportamiento del repositorio
        when(medicoService.filtroDocumentoMedico("123456789")).thenReturn(meidicos);

	medico.setDoc_medico("123456789");
	medico.setPrimer_nombre_medico("Carolina");
	medico.setPrimer_apellido_medico("Giraldo");
	medico.setCorreo_medico("torruiz@gmail.com");
	medico.setTelefono_medico("3548697535");
	ResponseEntity<Object> response = medicoController.save(medico);
	assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

}

}
