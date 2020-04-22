package ru.job4j.generic;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RoleAndUserStoreTest {

    @Test
    public void whenReplaceElementShouldReturnNewElement() {
        AbstractStore<Role> roleStore = new RoleStore();
        Role role1 = new Role("id1");
        Role role2 = new Role("id2");
        Role role3 = new Role("newRole");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.replace("id2", role3);
        assertThat(roleStore.findById("newRole"), is(role3));
    }

    @Test
    public void whenAddElementShouldReturnElement() {
        AbstractStore<User> userAbstractStore = new UserStore();
        User role1 = new User("id1");
        User role2 = new User("id2");
        userAbstractStore.add(role1);
        userAbstractStore.add(role2);
        assertThat(userAbstractStore.findById("id2"), is(role2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteShouldReturnNull() {
        AbstractStore<Role> roleStore = new RoleStore();
        roleStore.add(new Role("id1"));
        roleStore.add(new Role("id2"));
        roleStore.delete("id2");
        roleStore.findById("id2");
    }

}