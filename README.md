# qa_java
QA Java Project
## Описание проекта Sprint_6
Проект представляет собой тестовую систему для зоологов, изучающих семейство кошачьих. Включает тестирование классов, моделирующих поведение животных.

## Обязательное задание

### Технологии
- Java 11
- JUnit 4
- Mockito
- JaCoCo

### Структура проекта
src/
├── main/
│ └── java/
│ ├── com/example/
│ │ ├── Feline.java
│ │ ├── Cat.java
│ │ └── Lion.java
└── test/
└── java/
├── com/example/
│ ├── FelineTest.java
│ ├── CatTest.java
│ ├── LionTest.java
│ └── LionParamTest.java

### Требования к тестам
1. **100% покрытие** для:
   - `Feline`
   - `Cat` 
   - `Lion`
2. Использование **Mockito** для моков
3. **Параметризованные тесты** для ветвлений
4. Отдельный класс для параметризованных тестов

## Дополнительное задание

Создание класс льва Алекса из мультфильма «Мадагаскар». Он будет наследник льва.
Помимо обычных методов у него есть свои:
getFriends() возвращает список имён его друзей — зебры Марти, бегемотихи Глории и жирафа Мелман;
getPlaceOfLiving() возвращает место, где он живёт — Нью-Йоркский зоопарк.

Также нужно переопределить метод getKittens(), потому что у Алекса нет львят. А ещё — написать свой конструктор, так как в классе Lion нет дефолтного конструктора. Алекс самец, поэтому в конструктор класса Lion всегда будет передаваться одно и то же значение. 

Класс LionAlex

public class LionAlex  extends Lion {

    public LionAlex(Predator predator) throws Exception {
        super("Самец", predator);
    }

    @Override
    public int getKittens() {
        return 0; //у него нет детенышей
    }

    public List<String> getFriends() {
        return List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман"); //друзья Алекса
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк"; // живет в зоопарке Нью-Йорка
    }
}

Тесты для льва Алекса

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Predator predator;

    @Test
    public void getFriends_ReturnsCorrectList() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        assertEquals(List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман"), lionAlex.getFriends());
    }

    @Test
    public void getPlaceOfLiving_ReturnsZoo() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    public void getKittens_AlwaysReturnsZero() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        assertEquals(0, lionAlex.getKittens());
    }

    @Test
    public void constructor_SetsMaleSexAutomatically() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        assertTrue(lionAlex.doesHaveMane());
    }

    @Test
    public void getFood_CallsParentMethod() throws Exception {
        LionAlex lionAlex = new LionAlex(predator);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, lionAlex.getFood());
    }
}

Также по итогам сформирован отчет Jacoco (target/site/jacoco/)
<img width="956" alt="Снимок экрана 2025-06-10 в 00 45 15" src="https://github.com/user-attachments/assets/2a443250-fb47-4ef3-82fc-014655318560" />

В соответсвии с заданием 100% покрытие тестами у классов Feline, Cat и Lion.



