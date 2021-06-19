package com.truemeds.truemeds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.truemeds.truemeds.model.FinalOutput;

@Repository
public interface TruemedsJpaOutputRepository extends CrudRepository<FinalOutput, Long> {

}
