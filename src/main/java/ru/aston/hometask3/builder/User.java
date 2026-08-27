package ru.aston.hometask3.builder;

public class User {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final int age;
    private final String email;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String middleName;
        private int age;
        private String email;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() { return new User(this); }
    }

    public String toString() {
        return String.format(
                "User { firstName='%s', lastName='%s', middleName='%s', age=%d, email='%s' }",
                firstName,
                lastName,
                middleName,
                age,
                email
        );
    }
}
