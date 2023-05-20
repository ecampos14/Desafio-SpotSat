package spotSat.backenddesafio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spotSat.backenddesafio.DTO.RequestDTO;
import spotSat.backenddesafio.DTO.ResponseDTO;

@RestController
@RequestMapping("/v1/auth")
public class AuthenticatorController {

    @PostMapping
    public ResponseEntity<ResponseDTO> authenticate(@RequestBody RequestDTO requestDTO) {
        String email = requestDTO.getEmail();
        String password = requestDTO.getPassword();

        ResponseDTO response;

        if (email == null || password == null) {
            response = new ResponseDTO("Formato da requisição inválido!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if ("admin@exemplo.com.br".equals(email) && "abcd1234".equals(password)) {
            response = new ResponseDTO("Autenticado com sucesso!");
            return ResponseEntity.ok(response);
            
        } else {
            response = new ResponseDTO("Falha ao autenticar!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}