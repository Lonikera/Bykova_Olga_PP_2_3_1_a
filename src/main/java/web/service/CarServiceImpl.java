package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    public CarServiceImpl() {
        cars = Arrays.asList(
                new Car("Toyota", 10, 2020),
                new Car("Ford", 12, 2018),
                new Car("Honda", 11, 2019),
                new Car("Chevrolet", 5, 2017),
                new Car("Nissan", 14, 2021)
        );
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count >= cars.size() || count < 1) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }

}
