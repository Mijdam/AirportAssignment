package com.example.Airport.controller;

import com.example.Airport.model.Airplane;
import com.example.Airport.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AirplaneController {

    @Autowired
    private AirplaneRepository airplaneRepository;

    //Get all airplanes.
    @RequestMapping(value="api/airplane/", method = RequestMethod.GET)
    public Iterable<Airplane> getAll(){
        return airplaneRepository.findAll();
    }

    //Create a new airplane. Id is auto-generated.
    @RequestMapping(value="api/airplane/", method = RequestMethod.POST)
    public Airplane create(@RequestBody Airplane airplane){
        return airplaneRepository.save(airplane);
    }

    //Delete a specific airplane by putting its id in the url.
    @DeleteMapping("api/airplane/{id}")
    public void deleteAirplane(@PathVariable Long id) {
        airplaneRepository.deleteById(id);
    }

    //Update a specific airplane by putting its id in the url.
    @PutMapping("api/airplane/{id}")
    public ResponseEntity<Object> updateAirplane(@RequestBody Airplane airplane, @PathVariable long id) {

        Optional<Airplane> airplaneOptional = airplaneRepository.findById(id);

        if (!airplaneOptional.isPresent())
            return ResponseEntity.notFound().build();

        airplane.setId(id);

        airplaneRepository.save(airplane);

        return ResponseEntity.noContent().build();
    }

}
