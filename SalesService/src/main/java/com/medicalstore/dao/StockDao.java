package com.medicalstore.dao;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicalstore.dto.StockDto;


@FeignClient(name="STOCKSERVICE",url="http://localhost:9095")
public interface StockDao {
	
	@GetMapping("stocks/get/{id}")
    public ResponseEntity<StockDto> getStockById(@PathVariable Long id);

	
}
