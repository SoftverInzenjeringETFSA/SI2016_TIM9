package com.ws1001.repositories;

import com.ws1001.models.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ramic on 23.05.2017..
 */
public interface ReservationRepository  extends PagingAndSortingRepository<Reservation, Long> {
}
