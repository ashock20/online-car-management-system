package com.cg.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.car.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

}
