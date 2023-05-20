package spotSat.backenddesafio.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseDTO {

	private String mensagem;

	public ResponseDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMessage() {
        return mensagem;
    }

    public void setMessage(String message) {
        this.mensagem = message;
    }


}
