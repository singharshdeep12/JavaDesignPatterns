package builder;

// Director/ Client Code
public class Builder2 {

    public static void main(String[] args) {

        UserEntityBuilder arshBuilder = new UserEntityBuilderImpl();

        UserEntity2 arsh = arshBuilder
                .withName("Arshdeep Singh")
                .withAge(28)
                .buildUser();

        System.out.println(arsh);

    }

}

// Builder Interface class
interface UserEntityBuilder{

    public UserEntityBuilder withName(String name);

    public UserEntityBuilder withAge(int age);

    public UserEntityBuilder withAddress(String address);

    public UserEntity2 buildUser();
}

//Builder interface implementation class
class UserEntityBuilderImpl implements UserEntityBuilder{

    private UserEntity2 user;

    public UserEntityBuilderImpl() {
        user = new UserEntity2();
    }

    @Override
    public UserEntityBuilder withName(String name) {
        user.setName(name);
        return this;
    }

    @Override
    public UserEntityBuilder withAge(int age) {
        user.setAge(age);
        return this;
    }

    @Override
    public UserEntityBuilder withAddress(String address) {
        user.setAddress(address);
        return this;
    }

    @Override
    public UserEntity2 buildUser() {
        return user;
    }
}

//User Entity Class - with setters as package private (only builder can access)
class UserEntity2{

    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    void setAge(int age1) {
        this.age = age1;
    }

    public String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

}

