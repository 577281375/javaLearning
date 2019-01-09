package io.creams.entity.repository;

import io.creams.entity.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by frank on 2019-01-02.
 */

@Repository
public interface RoomRepository extends CrudRepository<Building, Long> {

    Iterable<Building> findByNameContains(String keyword);

}
