package com.medicalStore.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medicalStore.dto.ClientDto;

/**
 * DAO (Data Access Object) interface for communicating with the ClientService via Feign.
 */
@FeignClient(name="CLIENTSERVICE", url="http://localhost:9092")
public interface ClientDao {
    
    /**
     * Retrieves a client by its ID from the ClientService.
     * @param id The ID of the client to retrieve.
     * @return A ResponseEntity containing the client DTO.
     */
    @GetMapping("/clients/get/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id);
}
