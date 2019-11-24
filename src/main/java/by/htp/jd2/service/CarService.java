package by.htp.jd2.service;

import by.htp.jd2.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars(int page);

    int carCount();

    Car getCarById(int id);

    boolean deactivateCar(Car car);

    boolean activateCar(Car car);

    void addCar(Car car);
}
