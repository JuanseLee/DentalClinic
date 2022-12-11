package com.example.ClinicPFI.Services.ServiceImpl;

import com.example.ClinicPFI.Model.Entities.Address;
import com.example.ClinicPFI.Repositories.IAddressRepository;
import com.example.ClinicPFI.Services.IAddressService;
import com.example.ClinicPFI.Services.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImpl implements IAddressService {

    private static final Logger LOGGER = Logger.getLogger(AddressServiceImpl.class);

    @Autowired
    private final IAddressRepository addressRepository;
    @Autowired

    ObjectMapper mapper;

    public AddressServiceImpl() {
        addressRepository = null;
    }

    @Override
    public void saveAddress(Address address) {
LOGGER.info("Saving Address");
        addressRepository.save(address);
    }

    @Override
    public Optional<Address> getAddress(Long id) {
        LOGGER.info("Getting address");

        Optional<Address> address = addressRepository.findById(id);
        Address addressDto = null;
        if(address.isPresent())
            addressDto = mapper.convertValue(address, Address.class);

        return Optional.ofNullable(addressDto);
    }
    @Override
    public void updateAddress(Address addressDto) {
        Address address =mapper.convertValue(addressDto, Address.class);

        addressRepository.save(address);;
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);

    }



    @Override
    public Set<Address> getAll() {

        List<Address> addresss =  addressRepository.findAll();
        Set<Address> addresssDto = new HashSet<>();

        for (Address address: addresss){
            addresssDto.add(mapper.convertValue(address,Address.class));
        }

        return addresssDto;
    }
}

