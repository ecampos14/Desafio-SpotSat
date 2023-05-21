package spotSat.backenddesafio.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spotSat.backenddesafio.DTO.PlaceDTO;
import spotSat.backenddesafio.service.PlaceService;

@RestController
@RequestMapping("/v3/places")
public class PlacePartIIController {

	@Autowired
	private PlaceService placeService;

	@PostMapping
	public ResponseEntity<PlaceDTO> createPlace(@RequestBody PlaceDTO newPlace) {
		PlaceDTO createdPlace = placeService.createPlace(newPlace);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPlace);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PlaceDTO> updatePlace(@PathVariable Integer id, @RequestBody PlaceDTO updatedPlace) {
		PlaceDTO place = placeService.updatePlace(id, updatedPlace);
		if (place != null) {
			return ResponseEntity.ok(place);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deletePlace(@PathVariable Integer id) {
		boolean deleted = placeService.deletePlace(id);
		if (deleted) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Lugar removido com sucesso!");
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}
}
