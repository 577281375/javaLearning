package io.creams.controller;


import io.creams.entity.Building;
import io.creams.entity.repository.BuildingRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;


@RestController
@RequestMapping("buildings")
@AllArgsConstructor
public class BuildingController {

    private  BuildingRepository buildingRepository;

    @GetMapping
    public Iterable<Building> getBuildings() {
        return buildingRepository.findAll();
    }


    @PostMapping
    public void createBuilding(@RequestBody Building[] buildings) {
//        for(Building building:buildings){
//            buildingRepository.save(building);
//        }

        buildingRepository.saveAll(Arrays.asList(buildings));
    }

    @DeleteMapping(value="/delete/{id}")
    public void buildingDelete(@PathVariable("id") Long id) {
        buildingRepository.deleteById(id);
    }



    @PutMapping("/{id}")
    public void updateBuildings(@PathVariable("id") Long id,@RequestBody Building buildingDetail) {
         buildingRepository.save(buildingDetail);
    }




//    @PutMapping("/{id}")
//    public void updateBuildings(@PathVariable("id") Long id,@RequestBody Building buildingDetail) {
//        Optional<Building> building  = buildingRepository.findById(id);
//        building.ifPresent(i->{
//            i.setAddress(buildingDetail.getAddress());
//            i.setId(buildingDetail.getId());
//            i.setName(buildingDetail.getName());
//            i.setAreaSize(buildingDetail.getAreaSize());
//            i.setBuilding(buildingDetail.getBuilding());
//         });
//         buildingRepository.save(building);
//    }


//
//    @PutMapping("/{id}")
//    public void updateBuildings(@PathVariable("id") Long id,@RequestBody Building buildingDetail) {
//        Optional<Building> building  = buildingRepository.findById(id);
//        building.ifPresent(i->{
//            i.setAddress(buildingDetail.getAddress());
//            i.setName(buildingDetail.getName());
//            i.setAreaSize(buildingDetail.getAreaSize());
//            i.setBuilding(buildingDetail.getBuilding());
//        });
//        buildingRepository.save(building);
//    }




    @GetMapping("/search")
    public Iterable<Building> searchBuildings(@RequestParam String keyword) {
        return buildingRepository.findByNameContains(keyword);
    }

//    @PostMapping("/{id}/building")
//    public void deleteBuilding(@PathVariable Long id,@RequestBody Building building){
//        buildingRepository.save(building);
//    }

//    @PostMapping("/{id}/rooms")
//    public void addRoom(@PathVariable Long id,@RequestBody Room room){
//        Optional<Building> building = buildingRepository.findById(id);
//        building.ifPresent(b -> {
////            b.addRoom(room);
////            buildingRepository.save(b);
//        });
//    }



//    @PutMapping(value = "/person/{id}")
//    public Building personUpdate(@PathVariable("id") Integer id,
//                               @RequestParam("name") String name,
//                               @RequestParam("address") String address) {
//        Building person = new Person();
//        person.setId(id);
//        person.setName(name);
//        person.setAddress(address);
//        return personRepository.save(person);
//    }




//    @DeleteMapping(value = "/building/{id}")
//    public void buildingDelete(@PathVariable("id") Long id) {
//        buildingRepository.delete(id);
//    }


}
