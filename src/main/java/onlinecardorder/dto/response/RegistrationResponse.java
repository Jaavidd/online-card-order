package onlinecardorder.dto.response;

import java.io.Serializable;

public class RegistrationResponse implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public RegistrationResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegistrationResponse setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegistrationResponse setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
