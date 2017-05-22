package com.ws1001.repositories;

import com.ws1001.models.TakenKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by ramic on 22.05.2017..
 */
public interface TakenKeyRepository extends PagingAndSortingRepository<TakenKey, Long> {

}
