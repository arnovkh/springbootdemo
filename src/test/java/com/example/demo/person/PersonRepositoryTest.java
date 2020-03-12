package com.example.demo.person;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void WhenFindByFirstNameDataShouldBeReturned() {
        // given
        Person alex = new Person("alex", "Gordon");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Person found = personRepository.findPersonByFirstName("alex").orElse(null);
        // then
        Assert.assertEquals("alex",found.getFirstName());

    }
}
