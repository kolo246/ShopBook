package com.example.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "age")
    private int age;

    public static final class Builder {
        private Long id;
        private String name;
        private String surname;
        private String email;
        private String city;
        private String phoneNumber;
        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Users build() {
            Users user = new Users();

            user.name = this.name;
            user.surname = this.surname;
            user.email = this.email;
            user.city = this.city;
            user.phone = this.phoneNumber;
            user.age = this.age;

            return user;
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public static String[] usersRow(Users user){
        return new String[]{
                user.getId().toString(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getCity(),
                user.getPhone(),
                String.valueOf(user.getAge())};
    }
}
