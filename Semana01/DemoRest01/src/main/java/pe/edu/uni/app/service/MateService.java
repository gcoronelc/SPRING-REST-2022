package pe.edu.uni.app.service;

import org.springframework.stereotype.Service;

import pe.edu.uni.app.dto.OperacionesDto;

@Service
public class MateService {

	public OperacionesDto procesar(OperacionesDto dto) {
		dto.setSuma(dto.getNum1() + dto.getNum2());
		dto.setProducto(dto.getNum1() * dto.getNum2());
		return dto;
	}
	
	public int mayor(int num1, int num2) {
		int mayor = (num1 + num2) + Math.abs(num1 - num2);
		mayor = mayor / 2;
		return mayor;
	}
	
}
