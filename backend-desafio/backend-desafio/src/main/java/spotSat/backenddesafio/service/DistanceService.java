package spotSat.backenddesafio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import spotSat.backenddesafio.DTO.PlaceDTO;

@Service
public class DistanceService {
	private Map<Integer, PlaceDTO> placeDTO;

    public DistanceService() {
        placeDTO = new HashMap<>();
        addPlace(new PlaceDTO(1, "Praia de Copacabana", -22.966667, -43.186944));
        addPlace(new PlaceDTO(2, "Museu do Louvre", 48.860611, 2.337644));
        addPlace(new PlaceDTO(3, "Jardim Botânico", -23.623522, -46.698406));
        addPlace(new PlaceDTO(4, "Estátua da Liberdade", 40.689249, -74.044500));
    }

    private void addPlace(PlaceDTO place) {
        placeDTO.put(place.getId(), place);
    }

    public double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public double calculateDistanceBetweenPlaces(int id1, int id2) {
        PlaceDTO place1 = placeDTO.get(id1);
        PlaceDTO place2 = placeDTO.get(id2);

        double distance = calculateDistance(place1.getLatitude(), place1.getLongitude(),
                place2.getLatitude(), place2.getLongitude());

        return distance;
    }

    public List<PlaceDTO> getPlacesInRadius(double latitude, double longitude, double radius) {
        List<PlaceDTO> placesInRadius = new ArrayList<>();

        for (PlaceDTO place : placeDTO.values()) {
            double distance = calculateDistance(latitude, longitude,
                    place.getLatitude(), place.getLongitude());
            if (distance <= radius) {
                place.setDistance(distance);
                placesInRadius.add(place);
            }
        }

        return placesInRadius;
    }
}
