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

    @RequestMapping(value="api/airplane/", method = RequestMethod.GET)
    public Iterable<Airplane> getAll(){
        return airplaneRepository.findAll();
    }

    @RequestMapping(value="api/airplane/", method = RequestMethod.POST)
    public Airplane create(@RequestBody Airplane airplane){
        return airplaneRepository.save(airplane);
    }

    @DeleteMapping("api/airplane/{id}")
    public void deleteAirplane(@PathVariable Long id) {
        airplaneRepository.deleteById(id);
    }

//    @PutMapping("api/airplane/{id}")
//    public ResponseEntity<?> saveResource(@RequestBody Airplane airplane, @PathVariable("id") Long id) {
//        airplaneRepository.save(airplane);
//        return ResponseEntity.ok("resource saved");
//    }

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
