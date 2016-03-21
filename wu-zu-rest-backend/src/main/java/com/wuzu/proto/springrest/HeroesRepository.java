package com.wuzu.proto.springrest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Hyungchae Kim
 */
@RepositoryRestResource(collectionResourceRel = "heroes", path = "heroes")
public interface HeroesRepository extends PagingAndSortingRepository<Heroes, Long> {

	List<Heroes> findByLastName(@Param("name") String name);
}