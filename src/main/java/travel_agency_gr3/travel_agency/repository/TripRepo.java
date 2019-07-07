package travel_agency_gr3.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TripRepo extends JpaRepository<travel_agency_gr3.travel_agency.entity.Trip.Trip, Long> {

}
