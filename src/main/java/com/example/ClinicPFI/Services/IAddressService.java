package com.example.ClinicPFI.Services;

import com.example.ClinicPFI.Model.Entities.Address;

import java.util.Optional;
import java.util.Set;

public interface IAddressService {


    void saveAddress (Address address);
    void deleteAddress (Long id);
    void updateAddress (Address address);
    Optional<Address> getAddress (Long id);
    Set<Address> getAll();
}

