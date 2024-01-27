package builder;

public class Builder2 {
}


class UserEntity2{

    private String name1;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
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


    public static UserBuilder1 getBuilder(){
        return new UserBuilder1();
    }

    static class UserBuilder1{
        private UserEntity user;

        UserBuilder1(){
            user = new UserEntity();
        }

        public UserBuilder1 withName(String name){
            user.setName(name);
            return this;
        }

        public UserBuilder1 withAge(int age){
            user.setAge(age);
            return this;
        }

        public UserBuilder1 withAddress(String address){
            user.setAddress(address);
            return this;
        }

        public UserEntity buildUser(){
            return user;
        }

    }


}

