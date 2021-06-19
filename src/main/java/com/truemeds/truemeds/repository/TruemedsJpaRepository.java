package com.truemeds.truemeds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truemeds.truemeds.model.InputDetails;

@Repository
public interface TruemedsJpaRepository extends JpaRepository<InputDetails, Long> {

}
