package com.medicalStore.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.medicalStore.entity.CartServiceEntity;
import com.medicalStore.repository.CartServiceRepository;

/**
 * Service class responsible for managing cart-related operations.
 */
@Service
public class CartService {
    @Autowired
    CartServiceRepository cartServiceRepository;
    
    /**
     * Saves the provided cart entity into the database.
     * @param cart The cart entity to be saved.
     * @return The saved cart entity.
     */
    public CartServiceEntity saveCart(CartServiceEntity cart) {
        return cartServiceRepository.save(cart);
    }
    
    /**
     * Retrieves a cart entity from the database by its ID.
     * @param id The ID of the cart to retrieve.
     * @return The cart entity associated with the provided ID.
     */
    public CartServiceEntity getCart(Long id) {
        return cartServiceRepository.findById(id).get();
    }
}
