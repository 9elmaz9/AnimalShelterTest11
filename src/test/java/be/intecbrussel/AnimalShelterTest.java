package be.intecbrussel;

import be.intecbrussel.animal.Animal;
import be.intecbrussel.animal.Cat;
import be.intecbrussel.animal.Dog;
import be.intecbrussel.animal.Monkey;
import be.intecbrussel.shelter.AnimalShelter;
import be.intecbrussel.shelter.Disease;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalShelterTest {
    private AnimalShelter animalShelter;

    @BeforeEach
    void setUp() {
        animalShelter = new AnimalShelter();
        // Добавьте несколько животных для тестирования

        // animalShelter.addAnimal(new Monkey("Monkey1", 5, false));
        animalShelter.addAnimal(new Monkey(false ,5, "Monkey1", 1, false));
        animalShelter.addAnimal(new Cat("Cat1", 3, false));
        animalShelter.addAnimal(new Dog("Dog1", 4, false));
    }

    @Test
    void testPrintAnimals() {
        animalShelter.printAnimals();
        // В этом тесте нужно вручную проверить вывод на консоль
    }

    @Test
    void testSortAnimals() {
        animalShelter.sortAnimals();
        // В этом тесте нужно вручную проверить вывод на консоль
    }

    @Test
    void testSortAnimalByName() {
        animalShelter.sortAnimalByName();
        // В этом тесте нужно вручную проверить вывод на консоль
    }

    @Test
    void testSortAnimalByAge() {
        animalShelter.sortAnimalByAge();
        // В этом тесте нужно вручную проверить вывод на консоль
    }

    @Test
    void testPrintAnimalsNotVaccinated() {
        animalShelter.printAnimalsNotVaccinated(Disease.POLIO);
        // В этом тесте нужно вручную проверить вывод на консоль
    }

    @Test
    void testFindAnimalByAnimalNumber() {
        //Monkey monkey = new Monkey("Monkey1", 5, false);
        //animalShelter.addAnimal(new Monkey(false, 5, "Monkey1", 1, false));

        //animalShelter.addAnimal(monkey);

        Optional<Animal> foundAnimal = animalShelter.findAnimal(1);

        assertTrue(foundAnimal.isPresent());

        assertEquals("Cat1", foundAnimal.get().getName());
        assertEquals(1, foundAnimal.get().getAnimalNumber());
    }

    @Test
    void testFindAnimalByAnimalName() {
        Optional<Animal> foundAnimal = animalShelter.findAnimal("Cat1");
        assertTrue(foundAnimal.isPresent());
        assertEquals(3, foundAnimal.get().getAge());
    }

    @Test
    void testTreatAnimalByAnimalNumber() {
        animalShelter.treatAnimal(1);
        assertEquals(false, animalShelter.getAnimals().get(0).IsClean());
    }

    @Test
    void testTreatAnimalByAnimalName() {
        animalShelter.treatAnimal("Cat1");
        assertEquals(false, animalShelter.getAnimals().get(1).IsClean());
    }

    @Test
    void testTreatAllAnimal() {
        animalShelter.treatAllAnimal();
        // Проверьте, что все животные теперь чисты
        List<Animal> animals = animalShelter.getAnimals();
        assertFalse(animals.stream().allMatch(Animal::IsClean));
    }

    @Test
    void testFindOldestAnimal() {
        Animal oldestAnimal = animalShelter.findOldestAnimal();
        assertNotNull(oldestAnimal);
        // В этом тесте нужно вручную проверить вывод на консоль
    }

    @Test
    void testCountAnimals() {
        int count = animalShelter.countAnimals();
        assertEquals(3, count);
    }

    @Test
    void testAddAnimal() {
        Monkey newMonkey = new Monkey("Monkey2", 6, false);
        animalShelter.addAnimal(newMonkey);
        assertTrue(animalShelter.getAnimals().contains(newMonkey));
    }
}

