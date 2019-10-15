package by.htp.jd2.service.impl;

import by.htp.jd2.dao.CarDao;
import by.htp.jd2.entity.Car;
import by.htp.jd2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public List<Car> getAllCars(int page) {
        return carDao.getAllCars(page);
    }

    @Override
    @Transactional
    public int carCount() {
        return carDao.carCount();
    }

    @Override
    @Transactional
    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }

    @Override
    @Transactional
    public boolean deactivateCar(Car car) {
        return carDao.deactivateCar(car);
    }

    @Override
    @Transactional
    public boolean activateCar(Car car) {
        return carDao.activateCar(car);
    }
}
