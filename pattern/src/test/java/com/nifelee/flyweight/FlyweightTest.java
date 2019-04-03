package com.nifelee.flyweight;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 데이터를 공유 사용하여 메모리를 절약할 수 있는 패턴
 * ex) Integer.valueOf(127)
 */
public class FlyweightTest {
  static class PersonFactory {
    private static Map<String, Person> personMap = new HashMap<>();
    static Person getPerson(String name) {
      if (!personMap.containsKey(name))
        personMap.put(name, new Person(name));
      return personMap.get(name);
    }
  }
  @AllArgsConstructor static class Person {
    @Getter private String name;
  }

  @Test
  public void flyweight() {
    Person p1 = PersonFactory.getPerson("p1");
    Person p2 = PersonFactory.getPerson("p2");
    Person p3 = PersonFactory.getPerson("p1");
    assertFalse(p1 == p2);
    assertTrue(p1 == p3);
  }

}
