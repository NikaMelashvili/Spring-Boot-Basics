package crud.melashvili.mapping1.dao;

import crud.melashvili.mapping1.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Integer> {
}
