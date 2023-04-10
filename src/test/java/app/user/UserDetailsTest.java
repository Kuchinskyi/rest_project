package app.user;

import app.config.UsersHttpRequest;
import app.dto.usersDto.Person;
import app.dto.usersDto.User;
import app.dto.usersDto.UserDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserDetailsTest {

    private static UsersHttpRequest usersHttpRequest;

    @BeforeAll
    public static void setUsersHttpRequest() {
        usersHttpRequest = new UsersHttpRequest();
    }

    @Test
    public void testGetUserDetail() {
        UserDetail expectedDetail = new UserDetail(TestData.user, TestData.support);
        User actual = usersHttpRequest.getUsers(Integer.toString(TestData.id))
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("data", User.class);
                //.as(UserDetail.class);
        Assertions.assertEquals(expectedDetail.getData(), actual);
    }

    @Test
    public void createUser() {
        Person expected = new Person(TestData.userName, TestData.jobTitle, null, "2022-05-12T16:40:20.689Z");
        Person actual = usersHttpRequest.createUser(expected)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .as(Person.class);
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getJob(), actual.getJob());
    }
}
