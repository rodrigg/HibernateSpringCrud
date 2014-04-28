package com.rodionbykov.hibernate.test;

import com.rodionbykov.hibernate.CarService;
import com.rodionbykov.hibernate.entity.Car;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CarServiceTest {

    CarService service = new CarService();

    @Test
    public void testSaveRecord() throws Exception {
        Car car1 = new Car();
        car1.setName("BMW");
        car1.setCost(20000);
        car1.setReleaseDate(new Date());

        Car car = service.add(car1);

        System.out.println(car);
    }

    @Test
    public void testDeleteRecord() throws Exception {

        Car car1 = new Car();
        car1.setName("Ferrari");
        car1.setCost(100000);
        car1.setReleaseDate(new Date());

        Car car = service.add(car1);

        service.delete(car.getId());
    }

    @Test
    public void testSelect() throws Exception {

        Car car1 = new Car();
        car1.setName("Citroen");
        car1.setCost(30000);
        car1.setReleaseDate(new Date());

        Car car = service.add(car1);

        Car carFromDB = service.get(car.getId());
        System.out.println(carFromDB);
    }

    @Test
    public void testUpdate() throws Exception {
        Car car1 = new Car();
        car1.setName("Lambordshini");
        car1.setCost(5000000);
        car1.setReleaseDate(new Date());

        car1 = service.add(car1);

        car1.setName("Lamborghini");

        service.update(car1);

        Car car2 = service.get(car1.getId());
        System.out.println(car2);
    }

    public void testGetAll(){

        Car car1 = new Car();
        car1.setName("Lexus");
        car1.setCost(300000);
        car1.setReleaseDate(new Date());

        Car car2 = new Car();
        car2.setName("Fiat");
        car2.setCost(20000);
        car2.setReleaseDate(new Date());

        Car car3 = new Car();
        car3.setName("Porsche");
        car3.setCost(458000);
        car3.setReleaseDate(new Date());

        service.add(car1);
        service.add(car2);
        service.add(car3);

        List<Car> cars = service.getAll();

        for(Car c : cars){
            System.out.println(c);
        }
    }

}