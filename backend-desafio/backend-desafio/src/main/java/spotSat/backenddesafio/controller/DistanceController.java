package spotSat.backenddesafio.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spotSat.backenddesafio.DTO.PlaceDTO;
import spotSat.backenddesafio.service.DistanceService;

@RestController
@RequestMapping("/v4/places")
public class DistanceController {

	

	@Autowired
	private  DistanceService distanceService1;

	@GetMapping("/{id1}/distanceto/{id2}")
	public ResponseEntity<Map<String, Double>> getDistanceBetweenPlaces(@PathVariable("id1") Integer id1,
			@PathVariable("id2") Integer id2) {
		double distance = distanceService1.calculateDistanceBetweenPlaces(id1, id2);
		Map<String, Double> response = Collections.singletonMap("distance", distance);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/search")
	public ResponseEntity<List<PlaceDTO>> searchPlacesInRadius(@RequestParam("latitude") double latitude,
			@RequestParam("longitude") double longitude, @RequestParam("radius") double radius) {
		List<PlaceDTO> places = distanceService1.getPlacesInRadius(latitude, longitude, radius);
		return ResponseEntity.ok(places);
	}
}