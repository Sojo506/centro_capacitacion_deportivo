package model;

public abstract class Person {

    protected String name;
    protected String lastName;
    protected String city;
    protected String address;
    protected String phone;
    protected String email;
    protected boolean active;

    public Person() {
    }

    public Person(String name, String lastName, String city, String address,
            String phone, String email, boolean active) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
