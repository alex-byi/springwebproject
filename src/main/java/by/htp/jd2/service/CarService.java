package by.htp.jd2.service;

import by.htp.jd2.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars(int page);
    int carCount();
}
