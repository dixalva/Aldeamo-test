package com.aldeamo.test.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldeamo.test.persistence.entity.ArrayEntity;
import com.aldeamo.test.service.ArrayService;

@RestController
@RequestMapping("/test")
public class testController {

	@Autowired
	ArrayService arrayService;

	/**
	 * Array con numeros primos
	 */
	private List<Integer> primos = null;

	@GetMapping("/bartender/{q}/{id}")
	public ResponseEntity<String> getOne(@PathVariable("q") int q, @PathVariable("id") int id) {
		if (!arrayService.existsById(id)) {
			return new ResponseEntity("No existe id", HttpStatus.NOT_FOUND);
		}
		primos = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
		String respuesta;
		ArrayEntity array = arrayService.getOneById(id).get();
		StringTokenizer tokens = new StringTokenizer(array.getInputArray(), ",");
		List<Integer> arrayValues = new ArrayList<>();
		while (tokens.hasMoreElements()) {
			try {
				arrayValues.add(Integer.valueOf(tokens.nextToken().trim()));
			} catch (NumberFormatException e) {
				return new ResponseEntity(
						"Se encontro un valor no númerico en el arreglo: " + array.getInputArray().toString(),
						HttpStatus.NOT_ACCEPTABLE);
			}
		}
		if (q <= 0) {
			return new ResponseEntity("La cantidad de iteraciones debe ser un número mayor a cero",
					HttpStatus.NOT_ACCEPTABLE);
		}
		respuesta = generarRespuesta(arrayValues, q).toString();

		return new ResponseEntity(respuesta, HttpStatus.OK);
	}

	/**
	 * Realiza las operaciones para generar el arreglo respuesta
	 * 
	 * @param a Arreglo de numeros A
	 * @param q Cantidad de iteraciones
	 * @return List con números de respuesta
	 */
	private List<Integer> generarRespuesta(List<Integer> a, int q) {
		List<Integer> b = new ArrayList<>();
		List<Integer> a1 = new ArrayList<>();
		for (Integer numero : a) {
			if (numero % primos.get(0) == 0) {
				b.add(numero);
			} else {
				a1.add(numero);
			}
		}
		primos.remove(0);
		Collections.reverse(a1);
		Collections.reverse(b);
		if (--q > 0 && !a1.isEmpty()) {
			b.addAll(generarRespuesta(a1, q));
		} else {
			b.addAll(a1);
		}
		return b;
	}

}
