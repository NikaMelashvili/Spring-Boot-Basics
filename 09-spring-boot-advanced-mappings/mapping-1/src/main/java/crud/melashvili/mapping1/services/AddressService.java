package crud.melashvili.mapping1.services;

import crud.melashvili.mapping1.dao.AddressDAO;
import crud.melashvili.mapping1.dao.StudentDAO;
import crud.melashvili.mapping1.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressDAO addressDAO;

    public AddressService(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public void addAddress(Address address){
        addressDAO.save(address);
    }

    public Address getAddressById(int id){
        Address address = addressDAO.findById(id).get();
        return address;
    }

    public void updateAddressById(int id){
        Address address = addressDAO.findById(id).get();
        address.setAddress("chavchavadzis 8");
        addressDAO.save(address);
    }

    public void deleteAddressById(int id){
        Address address = addressDAO.findById(id).get();
        addressDAO.delete(address);
    }
}
