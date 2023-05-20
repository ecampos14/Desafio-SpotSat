package spotSat.backenddesafio.service;

import org.springframework.stereotype.Service;

import spotSat.backenddesafio.DTO.RequestDTO;
import spotSat.backenddesafio.DTO.ResponseDTO;

@Service
public class AuthenticatorService {
	
    public ResponseDTO authenticate(String email, String password) {
        if ("admin@exemplo.com.br".equals(email) && "abcd1234".equals(password)) {
            return new ResponseDTO("Autenticado com sucesso!");
        } else {
            return new ResponseDTO("Falha ao autenticar!");
        }
    }
}


