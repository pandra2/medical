package com.medicalStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity class representing a cart in the medical store.
 */
@Entity
@Table(name="cart")
public class CartServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long medicineId;
    private Long clientId;

    /**
     * Default constructor.
     */
    public CartServiceEntity() {
        super();
    }

    /**
     * Parameterized constructor.
     * @param id The ID of the cart.
     * @param medicineId The ID of the medicine in the cart.
     * @param clientId The ID of the client associated with the cart.
     */
    public CartServiceEntity(Long id, Long medicineId, Long clientId) {
        super();
        this.id = id;
        this.medicineId = medicineId;
        this.clientId = clientId;
    }

    /**
     * Get the ID of the cart.
     * @return The ID of the cart.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the cart.
     * @param id The ID of the cart.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the ID of the medicine in the cart.
     * @return The ID of the medicine in the cart.
     */
    public Long getMedicineId() {
        return medicineId;
    }

    /**
     * Set the ID of the medicine in the cart.
     * @param medicineId The ID of the medicine in the cart.
     */
    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }

    /**
     * Get the ID of the client associated with the cart.
     * @return The ID of the client associated with the cart.
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * Set the ID of the client associated with the cart.
     * @param clientId The ID of the client associated with the cart.
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     * Override toString() to provide a string representation of the object.
     */
    @Override
    public String toString() {
        return "CartServiceEntity [id=" + id  + ", medicineId=" + medicineId + ", clientId="
            + clientId + "]";
    }
}
