package app.user;

import app.config.UsersHttpRequest;
import app.dto.usersDto.Person;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static app.user.TestData.jobTitle;
import static app.user.TestData.userName;

public class TestUserRequest {

    private final UsersHttpRequest usersHttpRequest = new UsersHttpRequest();


    @Test
    public void testGetUser() {
        Response response = usersHttpRequest.getUsers("2");
        Integer userId = response.then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getInt("data.id");

        Assertions.assertEquals(userId, 2);
    }

    @Test
    public void testCreateUser() {
        Person person = new Person();
        person.setName(userName);
        person.setJob(jobTitle);

        Person p = usersHttpRequest.createUser(person)
                .then().statusCode(201)
                .extract()
                .as(Person.class);

        Assertions.assertEquals(person.getName(), p.getName());
        Assertions.assertEquals(person.getJob(), p.getJob());
    }
}
