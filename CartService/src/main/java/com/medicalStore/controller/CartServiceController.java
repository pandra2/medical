package com.medicalStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalStore.dao.ClientDao;
import com.medicalStore.dao.MedicineDao;
import com.medicalStore.dto.ClientDto;
import com.medicalStore.dto.MedicineDto;
import com.medicalStore.entity.CartServiceEntity;
import com.medicalStore.exception.ResourceNotFoundException;
import com.medicalStore.service.CartService;

// This class serves as a REST controller for managing cart-related operations in a medical store system.
@RestController
@RequestMapping("/cart")
public class CartServiceController {

    // Autowiring CartService bean for handling cart-related business logic.
    @Autowired
    CartService cartService;

    // Autowiring ClientDao bean for accessing client-related data.
    @Autowired
    ClientDao clientDao;

    // Autowiring MedicineDao bean for accessing medicine-related data.
    @Autowired
    MedicineDao medicineDao;

    // Endpoint for adding a new item to the cart.
    @PostMapping("/addCart")
    public ResponseEntity<CartServiceEntity> addAdmin(@RequestBody CartServiceEntity cart) {
        // Saving the cart item using the injected CartService bean.
        CartServiceEntity newCart = cartService.saveCart(cart);
        // Returning the saved cart item along with HTTP status 201 (Created).
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }

    // Endpoint for retrieving a cart item by its ID.
    @GetMapping("/getCart/{id}")
    public CartServiceEntity getCart(@PathVariable Long id) {
        // Fetching the cart item by its ID using the injected CartService bean.
        return cartService.getCart(id);
    }

    // Endpoint for retrieving a client by ID.
    @GetMapping("/getClient/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        // Fetching the client by ID using the injected ClientDao bean.
        ResponseEntity<ClientDto> client = clientDao.getClientById(id);
        // If client is not found, throwing a ResourceNotFoundException.
        if (client == null) {
            throw new ResourceNotFoundException("Client Not Found");
        }
        // Returning the client DTO.
        return client;
    }

    // Endpoint for retrieving a medicine by its ID.
    @GetMapping("/medicines/get/{id}")
    public ResponseEntity<MedicineDto> getMedicineById(@PathVariable Long id) {
        // Fetching the medicine by ID using the injected MedicineDao bean.
        ResponseEntity<MedicineDto> medicine = medicineDao.getMedicineById(id);
        // If medicine is not found, throwing a ResourceNotFoundException.
        if (medicine == null) {
            throw new ResourceNotFoundException("Medicine Not Found");
        }
        // Returning the medicine DTO.
        return medicine;
    }
}
