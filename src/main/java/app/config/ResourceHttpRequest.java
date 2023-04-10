package app.config;

import app.dto.usersDto.Person;
import io.restassured.response.Response;

public class ResourceHttpRequest extends BaseHttpRequest{

    private static final String resourceUrl ="/api/unknown";

    public Response getResource(String id) {
        return getRequestSpecification()
                .when()
                .get(resourceUrl +"/"+ id);
    }

    public Response createUser(Person person) {
        return getRequestSpecification()
                .when()
                .body(person)
                .post(resourceUrl);
    }




}
