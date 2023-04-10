package app.resource;

import app.dto.resourceDto.Resource;
import app.dto.resourceDto.SupportResource;
import app.dto.usersDto.Support;
import app.dto.usersDto.User;

public interface TestData {
    Integer id = 2;
    String name = "fuchsia rose";
    Integer year = 2001;
    String color = "#C74375";
    Resource resource = new Resource(id, name, year, color);
    SupportResource supportResource = new SupportResource("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
}
