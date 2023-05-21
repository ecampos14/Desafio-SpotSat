package spotSat.backenddesafio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceDTO {

	private Integer id;
	private String name;
	private double latitude;
	private double longitude;


	public void setDistance(double distance) {
		// TODO Auto-generated method stub
		
	}
}
