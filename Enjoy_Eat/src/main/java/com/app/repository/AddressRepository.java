package com.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Address;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
