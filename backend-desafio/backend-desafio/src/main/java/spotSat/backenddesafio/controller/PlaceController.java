package spotSat.backenddesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spotSat.backenddesafio.DTO.PlaceDTO;
import spotSat.backenddesafio.service.PlaceService;

@RestController
@RequestMapping("/v2/places")
public class PlaceController {

	@Autowired
    private PlaceService placeService;

    @GetMapping
    public List<PlaceDTO> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public PlaceDTO getPlaceById(@PathVariable Integer id) {
        return placeService.getPlaceById(id);
    }
}

