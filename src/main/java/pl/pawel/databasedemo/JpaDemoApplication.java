package pl.pawel.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pawel.databasedemo.entity.Person;
import pl.pawel.databasedemo.jdbc.PersonJdbcDao;
import pl.pawel.databasedemo.jpa.PersonJpaRepository;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("User id 10001 -> {}", repository.findById(10001));
        logger.info("Inserting -> {}", repository.insert(new Person( "Tara", "Berlin", new Date())));
        logger.info("Updating 10003 -> {}", repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
        repository.deleteById(10002);
        logger.info("All users -> {}", repository.findAll());

//        logger.info("User name John -> {}", repository.findByName("John"));
//        logger.info("Deleting 10002 -> No of Rows Deleted - {}", repository.deleteById(10002));

    }
}
