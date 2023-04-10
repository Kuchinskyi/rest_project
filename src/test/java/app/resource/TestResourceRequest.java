package app.resource;

import app.config.ResourceHttpRequest;
import app.dto.resourceDto.Resource;
import app.dto.resourceDto.ResourceDetail;
import app.dto.usersDto.UserDetail;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static app.resource.TestData.*;


public class TestResourceRequest {

    private final ResourceHttpRequest resourceHttpRequest = new ResourceHttpRequest();

    @Test
    public void testGetResource() {
        ResourceDetail expected = new ResourceDetail(resource, supportResource);
        Response response = resourceHttpRequest.getResource("2");
        ResourceDetail resourceDetail = response.then()
                .statusCode(200)
                .extract()
                .as(ResourceDetail.class);
        Assertions.assertEquals(expected, resourceDetail);
    }

    @Test
    public void testGetResourceData() {
        Response response = resourceHttpRequest.getResource("2");
        Resource resource = response.then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("data", Resource.class);
        Assertions.assertEquals(resource, resource);
    }

    @Test
    public void testGetResourceId() {
        Response response = resourceHttpRequest.getResource("2");
        Integer resourceId = response.then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getInt("data.id");
        Assertions.assertEquals(resourceId, 2);
    }
}
