package com.nifelee.factory;

import org.junit.Test;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 팩토리 메소드 패턴
 * - 객체를 생성하기 위한 인터페이스를 정의하는데, 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정
 * - 클래스의 인스턴스를 만드는 일을 서브클래스에게 맡기는 것
 * ex) Calendar.getInstance()
 *
 * 추상 팩토리 패턴
 * - 인터페이스를 이용하여 서로 연관된, 또는 의존하는 객체를 구상 클래스를 지정하지 않고도 생성.
 *
 * 팩토리 메소드 패턴과의 가장 기본적인 차이점은
 * 팩토리 메소드 패턴이 클래스가 객체를 생성하는 패턴이라고 하면, (클래스->객체, Xxx.newInstance())
 * 추상 팩토리 패턴에서는 객체가 객체를 만드는 방법이라는 점이다. (객체->객체, xxx.createInstance())
 */
@Slf4j
public class FactoryTest {
  enum PizzaType { PEPPERONI, CHEESE }

  abstract class PizzaStore {
    abstract Pizza createPizza(PizzaType pizzaType);
    Pizza order(PizzaType pizzaType) {
      Pizza pizza = createPizza(pizzaType);
      pizza.prepare();
      pizza.bake();
      pizza.cut();
      return pizza;
    }
  }

  class NyPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(PizzaType pizzaType) {
      Pizza pizza = null;
      switch (pizzaType) {
        case CHEESE:
          pizza = new NyCheesePizza();
          break;
        case PEPPERONI:
          throw new IllegalArgumentException("not impl");
      }
      return pizza;
    }
  }

  @Getter @Setter abstract class Pizza {
    private String name;
    private String sauce;
    void prepare() {
      log.debug(name);
      log.debug("add sauce : {}", sauce);
    }
    void bake() { log.debug("baking.."); }
    void cut() { log.debug("cutting.."); }
  }

  class NyCheesePizza extends Pizza {
    NyCheesePizza() {
      super.setName("NY Cheese Pizza");
      super.setSauce("Cheese");
    }
  }

  @Test
  public void pizza() {
    PizzaStore pizzaStore = new NyPizzaStore();
    Pizza pizza = pizzaStore.order(PizzaType.CHEESE);
    log.debug(pizza.getName());
  }

}
