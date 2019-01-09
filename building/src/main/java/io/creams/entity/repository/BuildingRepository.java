package io.creams.entity.repository;

import io.creams.entity.Building;
import io.creams.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToMany;



@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {

    Iterable<Building> findAll();

    Iterable<Building> findByNameContains(String keyword);

    void deleteById(Long id);


//
//    @OneToMany()
//    private List<Room> rooms;



//    public void addRoom(Room room){
//        room.setBuilding(this);
//        room.add(room);
//    }


}
