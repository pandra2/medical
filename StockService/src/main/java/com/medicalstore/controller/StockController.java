package com.medicalstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.medicalstore.entity.Stock;
import com.medicalstore.service.StockService;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;
   

    @GetMapping("/allStocks")
    public ResponseEntity<List<Stock>> getAllStock() {
        List<Stock> stocks = stockService.getAllStock();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Stock stock = stockService.getStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PostMapping("/saveStock")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock newStock = stockService.saveStock(stock);
        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
   }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStockById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/stockbymedicine/{medicineId}")
    public ResponseEntity<Stock> getStockByMedicineId(@PathVariable Long medicineId) {
        Stock stock = stockService.getStockByMedicineId(medicineId);
        if (stock != null) {
            return new ResponseEntity<>(stock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        
        
        
       
        

    
}

