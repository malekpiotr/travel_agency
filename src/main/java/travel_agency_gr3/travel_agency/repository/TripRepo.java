package travel_agency_gr3.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import travel_agency_gr3.travel_agency.entity.Trip;


@Repository
public interface TripRepo<T extends Trip> extends JpaRepository<Trip, Long>, QuerydslPredicateExecutor<Trip> {

}
