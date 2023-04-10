package app.dto.resourceDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {

    private Integer id;
    private String name;
    private Integer year;
    private String color;

    public Resource() {}

    public Resource(Integer id, String name, Integer year, String color) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource user = (Resource) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name)
                && Objects.equals(year, user.year) && Objects.equals(color, user.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, color);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }
}
