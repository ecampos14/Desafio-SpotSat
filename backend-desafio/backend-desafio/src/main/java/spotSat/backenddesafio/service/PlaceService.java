package spotSat.backenddesafio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import spotSat.backenddesafio.DTO.PlaceDTO;

import java.util.ArrayList;

@Service
public class PlaceService {
	private Map<Integer, PlaceDTO> placeDTO;

	public PlaceService() {
		placeDTO = new HashMap<>();
		addPlace(new PlaceDTO(1, "Praia de Copacabana", -22.966667, -43.186944));
		addPlace(new PlaceDTO(2, "Museu do Louvre", 48.860611, 2.337644));
		addPlace(new PlaceDTO(3, "Jardim Botânico", -23.623522, -46.698406));
		addPlace(new PlaceDTO(4, "Estátua da Liberdade", 40.689249, -74.044500));
	}

	public List<PlaceDTO> getAllPlaces() {
		return new ArrayList<>(placeDTO.values());
	}

	public PlaceDTO getPlaceById(int id) {
		return placeDTO.get(id);
	}

	private void addPlace(PlaceDTO placedto) {
		placeDTO.put(placedto.getId(), placedto);
	}

	public PlaceDTO createPlace(PlaceDTO newPlace) {
		int id = generateNextId();
		newPlace.setId(id);
		placeDTO.put(id, newPlace);
		return newPlace;
	}

	public PlaceDTO updatePlace(int id, PlaceDTO updatedPlace) {
		PlaceDTO place = placeDTO.get(id);
		if (place != null) {
			updatedPlace.setId(id);
			placeDTO.put(id, updatedPlace);
			return updatedPlace;
		}
		return null;
	}

	public boolean deletePlace(int id) {
		return placeDTO.remove(id) != null;
	}

	private Integer generateNextId() {
		Integer maxId = placeDTO.keySet().stream().max(Integer::compareTo).orElse(0);
		return maxId + 1;
	}


}
