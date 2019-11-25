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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    //CARS/////////////////////////////////////////////////////
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


    @RequestMapping(value = "/admin/add_car", method = RequestMethod.GET)
    public ModelAndView addCarPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("car", new Car());
        modelAndView.setViewName("admin/add_car");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addCar")
    public ModelAndView addCar(@ModelAttribute("car") Car car) {
        carService.addCar(car);
        return controlCars(1);
    }


    //Control USERS//////////////////////////////////////////////////////////

    @RequestMapping(value = "admin/getUser")
    public ModelAndView getUser(@RequestParam("userLogin") String login) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/control_user");
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

    @RequestMapping(value = "/admin/changeRole")
    public ModelAndView changeRole(@RequestParam int idUser) {
        User user = userService.getUserById(idUser);
        userService.changeRole(user);
        return new ModelAndView("redirect:/admin/control_user");
    }

    @RequestMapping(value = "/admin/changeActivity")
    public ModelAndView changeActivity(@RequestParam int idUser) {
        User user = userService.getUserById(idUser);
        userService.changeActivity(user);
        return new ModelAndView("redirect:/admin/control_user");
    }

    @RequestMapping(value = "/admin/addCash")
    public ModelAndView addCash(@RequestParam int idUser, int cash) {
        User user = userService.getUserById(idUser);
        userService.addCash(user, cash);
        return new ModelAndView("redirect:/admin/control_user");
    }


    //COMMON///////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/common/addUser")
    public ModelAndView addUser(@ModelAttribute("user") User user) throws NoSuchAlgorithmException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/login");
        user.setRole("USER");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(StandardCharsets.UTF_8.encode(user.getPassword()));
        user.setPassword(String.format("%032x", new BigInteger(1, md5.digest())));
        userService.addUser(user);
        modelAndView.addObject("registration", "Registration OK");
        return modelAndView;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/index");
        return modelAndView;
    }


    @RequestMapping(value = "/common/register", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("common/register");
        return modelAndView;
    }


    @RequestMapping(value = "/common/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/login");
        return modelAndView;
    }

    @RequestMapping(value = "/common/profile", method = RequestMethod.GET)
    public ModelAndView adminProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(authentication.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/profile");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/common/changeEmail")
    public ModelAndView changeEmail(@RequestParam int idUser, String email) {
        userService.changeEmail(userService.getUserById(idUser), email);
        return new ModelAndView("redirect:/common/profile");
    }

    @RequestMapping(value = "/common/changePassword")
    public ModelAndView changePassword(@RequestParam int idUser, String oldPassword, String newPassword) throws NoSuchAlgorithmException {
        User user = userService.getUserById(idUser);

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(StandardCharsets.UTF_8.encode(oldPassword));
        String oldFormPassword = String.format("%032x", new BigInteger(1, md5.digest()));

        if (oldFormPassword.equals(user.getPassword())) {
            md5.update(StandardCharsets.UTF_8.encode(newPassword));
            String password = String.format("%032x", new BigInteger(1, md5.digest()));
            userService.changePassword(user, password);
        }
        return new ModelAndView("redirect:/common/profile");
    }


    //CONTROL ORDERS///////////////////////////////////////////////////////////////////////
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

    @RequestMapping(value = "/admin/completeOrder")
    public ModelAndView completeOrder(@RequestParam int idOrder) {
        Order order = orderService.getOrderById(idOrder);
        orderService.completeOrder(order);
        return new ModelAndView("redirect:/admin/control_orders");
    }

    @RequestMapping(value = "/admin/cancelOrder")
    public ModelAndView cancelOrder(@RequestParam int idOrder, String reason) {
        Order order = orderService.getOrderById(idOrder);
        orderService.cancelOrder(order, reason);
        return new ModelAndView("redirect:/admin/control_orders");
    }

    @RequestMapping(value = "/admin/addCrashPage")
    public ModelAndView addCrashPage(@RequestParam int idUser, int idCar, int idOrder) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("idUser", idUser);
        modelAndView.addObject("idCar", idCar);
        modelAndView.addObject("idOrder", idOrder);
        modelAndView.setViewName("admin/add_crash");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addCrash")
    public ModelAndView addCrash(@RequestParam int idUser, int idCar, int idOrder, int amount, String description) {
        Crash crash = new Crash();
        crash.setIdCar(idCar);
        crash.setIdUser(idUser);
        crash.setAmount(amount);
        crash.setDescription(description);
        crash.setComplete(false);
        crashService.addCrash(crash);
        orderService.setCrash(orderService.getOrderById(idOrder), crash);
        return new ModelAndView("redirect:/admin/control_orders");
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

    @RequestMapping(value = "/user/orders", method = RequestMethod.GET)
    public ModelAndView userOrders(@RequestParam(defaultValue = "1") int page) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(authentication.getName());
        List<Order> orders = orderService.getUserOrders(user.getId(), page);
        int orderCount = orderService.userOrderCount(user.getId());
        int pagesCount = (orderCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/orders");
        modelAndView.addObject("orders", orders);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("ordersCount", orderCount);
        return modelAndView;
    }

    @RequestMapping(value = "/user/crashes", method = RequestMethod.GET)
    public ModelAndView userCrashes(@RequestParam(defaultValue = "1") int page) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(authentication.getName());
        List<Crash> crashes = crashService.getUserCrashes(user.getId(), page);
        int crashCount = crashService.userCrashCount(user.getId());
        int pagesCount = (crashCount + 3) / 4;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/crashes");
        modelAndView.addObject("crashes", crashes);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("crashCount", crashCount);
        return modelAndView;
    }


    @RequestMapping(value = "/user/new_order", method = RequestMethod.GET)
    public ModelAndView newOrderUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/new_order");
        return modelAndView;
    }

    @RequestMapping(value = "/user/newOrdersDates")
    public ModelAndView newOrdersDates(@RequestParam String dates) throws ParseException {

        String dateStart = dates.substring(0, 10);
        String dateEnd = dates.substring(13, 23);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateS = dateFormat1.parse(dateStart);
        Date dateE = dateFormat1.parse(dateEnd);

        String startDate = dateFormat.format(dateS);
        String endDate = dateFormat.format(dateE);


        long milliseconds = dateE.getTime() - dateS.getTime();
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000)) + 1;

        List<Car> availableCars = carService.getAllAvailableCars(startDate, endDate);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("step", "step2");
        modelAndView.addObject("availableCars", availableCars);
        modelAndView.addObject("days", days);
        modelAndView.addObject("startDate", startDate);
        modelAndView.addObject("endDate", endDate);
        modelAndView.setViewName("user/new_order");
        return modelAndView;
    }


}
