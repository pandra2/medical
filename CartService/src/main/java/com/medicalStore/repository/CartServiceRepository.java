package com.medicalStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalStore.entity.CartServiceEntity;

/**
 * Repository interface for managing CartServiceEntity objects using Spring Data JPA.
 */
@Repository
public interface CartServiceRepository extends JpaRepository<CartServiceEntity, Long> {

}
