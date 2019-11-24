package by.htp.jd2.controller;

import by.htp.jd2.entity.Car;
import by.htp.jd2.entity.Crash;
import by.htp.jd2.entity.Order;
import by.htp.jd2.entity.User;
import by.htp.jd2.service.CarService;
import by.htp.jd2.service.CrashService;
import by.htp.jd2.service.OrderService;
import by.htp.jd2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private CrashService crashService;

    @Autowired
    public void setCrashService(CrashService crashService) {
        this.crashService = crashService;
    }

    @RequestMapping(value = "/user/cars", method = RequestMethod.GET)
    public ModelAndView allCars(@RequestParam(defaultValue = "1") int page) {
        List<Car> cars = carService.getAllCars(page);
        int carCount = carService.carCount();
        int pagesCount = (carCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/cars");
        modelAndView.addObject("cars", cars);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("carsCount", carCount);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/control_car", method = RequestMethod.GET)
    public ModelAndView controlCars(@RequestParam(defaultValue = "1") int page) {
        List<Car> cars = carService.getAllCars(page);
        int carCount = carService.carCount();
        int pagesCount = (carCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/control_car");
        modelAndView.addObject("cars", cars);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("carsCount", carCount);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/deactivateCar")
    public ModelAndView deactivateCar(@RequestParam int idCar) {
        Car car = carService.getCarById(idCar);
        carService.deactivateCar(car);
        return controlCars(1);
    }

    @RequestMapping(value = "/admin/activateCar")
    public ModelAndView activateCar(@RequestParam int idCar) {
        Car car = carService.getCarById(idCar);
        carService.activateCar(car);
        return controlCars(1);
    }

    @RequestMapping(value = "/getUser")
    public ModelAndView getUser(@RequestParam("userLogin") String login) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/index");
        User userLogin = userService.getUser(login);
        modelAndView.addObject("userLogin", userLogin);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/control_user", method = RequestMethod.GET)
    public ModelAndView allUsers(@RequestParam(defaultValue = "1") int page) {
        List<User> users = userService.getAllUsers(page);
        int userCount = userService.userCount();
        int pagesCount = (userCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/control_user");
        modelAndView.addObject("users", users);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("usersCount", userCount);
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/index");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/add_car", method = RequestMethod.GET)
    public ModelAndView addCarPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/add_car");
        return modelAndView;
    }

    @RequestMapping(value = "/common/register", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("common/register");
        return modelAndView;
    }

    @RequestMapping(value = "/common/addUser")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/login");
        user.setRole("USER");
        userService.addUser(user);
        modelAndView.addObject("registration", "Registration OK");
//        modelAndView.addObject("user", user);
        return modelAndView;
    }


    @RequestMapping(value = "/common/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/login");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/control_orders", method = RequestMethod.GET)
    public ModelAndView controlOrders(@RequestParam(defaultValue = "1") int page) {
        List<Order> orders = orderService.getAllOrders(page);
        int orderCount = orderService.orderCount();
        int pagesCount = (orderCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/control_orders");
        modelAndView.addObject("orders", orders);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("ordersCount", orderCount);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/control_crashs", method = RequestMethod.GET)
    public ModelAndView controlCrashs(@RequestParam(defaultValue = "1") int page) {
        List<Crash> crashs = crashService.getAllCrashs(page);
        int crashsCount = crashService.crashCount();
        int pagesCount = (crashsCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/control_crashs");
        modelAndView.addObject("crashs", crashs);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("crashsCount", crashsCount);
        return modelAndView;
    }



}
