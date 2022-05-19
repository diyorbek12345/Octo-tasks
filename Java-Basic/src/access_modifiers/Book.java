package access_modifiers;

import java.util.Objects;

public class Book {

    private String name;

    private StatusEnum statusEnum;

    public Book(String name, StatusEnum statusEnum) {
        this.name = name;
        this.statusEnum = statusEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusEnum getStatus() {
        return statusEnum;
    }

    public void setStatus(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", status=" + statusEnum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && statusEnum == book.statusEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, statusEnum);
    }
}
