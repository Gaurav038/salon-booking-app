package com.gaurav.service;

import java.util.List;

import com.gaurav.model.Salon;
import com.gaurav.payload.dto.SalonDTO;
import com.gaurav.payload.dto.UserDTO;

public interface SalonService {
    Salon createSalon(SalonDTO salon, UserDTO user);

    Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception;

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId) throws Exception;

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCity(String city);

}
