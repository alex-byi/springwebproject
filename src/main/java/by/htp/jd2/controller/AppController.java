package by.htp.jd2.controller;

import by.htp.jd2.entity.Car;
import by.htp.jd2.entity.User;
import by.htp.jd2.service.CarService;
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

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView allCars(@RequestParam(defaultValue = "1") int page) {
        List<Car> cars = carService.getAllCars(page);
        int carCount = carService.carCount();
        int pagesCount = (carCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cars");
        modelAndView.addObject("cars", cars);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("carsCount", carCount);
        return modelAndView;
    }

    @RequestMapping(value = "/control_car", method = RequestMethod.GET)
    public ModelAndView controlCars(@RequestParam(defaultValue = "1") int page) {
        List<Car> cars = carService.getAllCars(page);
        int carCount = carService.carCount();
        int pagesCount = (carCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("control_car");
        modelAndView.addObject("cars", cars);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("carsCount", carCount);
        return modelAndView;
    }

    @RequestMapping(value = "/control_user", method = RequestMethod.GET)
    public ModelAndView allUsers(@RequestParam(defaultValue = "1") int page) {
        List<User> users = userService.getAllUsers(page);
        int userCount = userService.userCount();
        int pagesCount = (userCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("control_user");
        modelAndView.addObject("users", users);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("usersCount", userCount);
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/add_car", method = RequestMethod.GET)
    public ModelAndView addCarPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add_car");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authPage");
        user.setRole("USER");
        userService.addUser(user);
        modelAndView.addObject("registration", "Registration OK");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @RequestMapping(value = "/getUser")
    public ModelAndView getUser(@RequestParam("userLogin") String login) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        User userLogin = userService.getUser(login);
        modelAndView.addObject("userLogin", userLogin);
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
