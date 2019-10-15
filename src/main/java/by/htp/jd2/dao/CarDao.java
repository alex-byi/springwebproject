package by.htp.jd2.dao;

import by.htp.jd2.entity.Car;

import java.util.List;

public interface CarDao {

    List<Car> getAllCars(int page);
    int carCount();
    Car getCarById(int id);
    boolean deactivateCar(Car car);
    boolean activateCar(Car car);


}
