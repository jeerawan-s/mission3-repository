package com.devtraining.mission3repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MusicStoreController {
    @Autowired
    private MusicStoreRepository musicStoreRepository;

    //return all
    @RequestMapping("/music")
    public List<MusicStoreModel> getMusic() {
        return musicStoreRepository.findAll();
    }

    //return by id
    @RequestMapping("/music/{id}")
    public Optional<MusicStoreModel> getMusic(@PathVariable("id") String id) {
        return musicStoreRepository.findById(id);
    }

    //add
    @RequestMapping(method = RequestMethod.POST, value = "/music")
    public void addMusic(@RequestBody MusicStoreModel music) {
        musicStoreRepository.insert(music);
    }

    //update
    @RequestMapping(method = RequestMethod.PUT, value = "/music/{id}")
    public void updateMusic(@RequestBody MusicStoreModel music, @PathVariable("id") String id) {
        musicStoreRepository.update(music);
    }

    //delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/music/{id}")
    public void deleteMusic(@PathVariable("id") String id) {
        musicStoreRepository.deleteById(id);
    }
}

