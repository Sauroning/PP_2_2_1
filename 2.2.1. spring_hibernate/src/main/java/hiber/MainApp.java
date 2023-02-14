package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car car1 = new Car("Honda", 4);
        Car car2 = new Car("Mazda", 5);
        Car car3 = new Car("BMW", 6);
        Car car4 = new Car("Lada", 15);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user1@mail.ru");
        User user3 = new User("User3", "Lastname3", "user1@mail.ru");
        User user4 = new User("User4", "Lastname4", "user1@mail.ru");

        user1.setCar(car1);
        user2.setCar(car1);
        user3.setCar(car1);
        user4.setCar(car1);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        List<User> users1 = userService.getUserByCar(car1);
        for (User user : users1){
            System.out.println(user.toString());
        }

        context.close();
    }
}
