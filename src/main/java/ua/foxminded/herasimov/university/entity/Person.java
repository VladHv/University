package ua.foxminded.herasimov.university.entity;

import java.util.Objects;

public abstract class Person {
    protected Integer id;
    protected String firstName;
    protected String lastName;

    protected Person() {
    }

    protected abstract static class ABuilder<T extends Person, B extends ABuilder<T, B>> {
        protected T object;
        protected B thisObject;

        protected abstract T getObject();

        protected abstract B thisObject();

        protected ABuilder() {
            object = getObject();
            thisObject = thisObject();
        }

        public B withId(Integer id) {
            object.id = id;
            return thisObject;
        }

        public B withFirstName(String firstName) {
            object.firstName = firstName;
            return thisObject;
        }


        public B withLastName(String lastName) {
            object.lastName = lastName;
            return thisObject;
        }

        public T build() {
            return object;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) &&
               Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
