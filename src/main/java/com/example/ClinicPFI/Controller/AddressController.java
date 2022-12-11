package com.example.ClinicPFI.Controller;

import com.example.ClinicPFI.Model.Entities.Address;
import com.example.ClinicPFI.Services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody Address address){

        addressService.saveAddress(address);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Address> getAppointment(@PathVariable Long id){

        return addressService.getAddress(id);
    }

    @GetMapping()
    public Collection<Address> getAppointments() {

        return addressService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (addressService.getAddress(id).isPresent()){
            addressService.deleteAddress(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @PutMapping
    public ResponseEntity<?> updateAppointment(@RequestBody Address addressDto)
    {
        addressService.updateAddress(addressDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
