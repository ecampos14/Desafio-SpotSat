package spotSat.backenddesafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spotSat.backenddesafio.DTO.ResponseDTO;

@RestController
@RequestMapping("/v1")
@ResponseBody
public class WelcomeController {
	
	@GetMapping("/")
	public ResponseEntity<ResponseDTO> getWelcomeMessage() {
		ResponseDTO response = new ResponseDTO("Bem vindo a API GeoPoly!");
		return ResponseEntity.ok(response);
	}
}