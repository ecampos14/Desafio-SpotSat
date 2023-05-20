package spotSat.backenddesafio.DTO;

import lombok.Data;

@Data
public class PlaceDTO {

	private Integer id;
	private String name;
	private double latitude;
	private double longitude;
	
	public PlaceDTO(Integer id, String name, double latitude, double longitude) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

}
