package com.medicalStore.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicalStore.dto.MedicineDto;

/**
 * DAO (Data Access Object) interface for communicating with the MedicineService via Feign.
 */
@FeignClient(name="MEDICINESERVICE")
public interface MedicineDao {
    
    /**
     * Retrieves a medicine by its ID from the MedicineService.
     * @param id The ID of the medicine to retrieve.
     * @return A ResponseEntity containing the medicine DTO.
     */
    @GetMapping("/medicines/get/{id}")
    public ResponseEntity<MedicineDto> getMedicineById(@PathVariable Long id);
    
    /**
     * Updates a medicine with the provided ID using the MedicineService.
     * @param id The ID of the medicine to update.
     * @param updatedMedicine The updated medicine DTO.
     * @return A ResponseEntity containing the updated medicine DTO.
     */
    @PutMapping("/medicines/update/{id}")
    public ResponseEntity<MedicineDto> updateMedicine(@PathVariable Long id, @RequestBody MedicineDto updatedMedicine);
}
