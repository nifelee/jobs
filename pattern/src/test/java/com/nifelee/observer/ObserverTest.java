package com.nifelee.observer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 한객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many) 의존성을 정의
 * ex) 날씨
 *
 * 푸시 방식 : 주제 객체에서 옵저버로 데이터를 보내는 방식
 * 풀 방식 : 옵저버에서 주제 객체의 데이터를 가져가는 방식
 *
 * 디자인 원칙
 * 서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용
 */
public class ObserverTest {

  interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
  }

  interface Observer {
    void update(int temperature);
  }

  class WeatherData implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;
    void temperatureChange(int temperature) {
      this.temperature = temperature;
      this.notifyObservers();
    }
    @Override
    public void registerObserver(Observer observer) {
      this.observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
      if (this.observers.contains(observer))
        this.observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
      for (Observer observer : observers)
        observer.update(temperature);
    }
  }

  class CurrentCondition implements Observer {
    private Subject subject;
    private int temperature;
    CurrentCondition(Subject subject) {
      this.subject = subject;
      this.subject.registerObserver(this);
    }
    @Override
    public void update(int temperature) {
      this.temperature = temperature;
      this.display();
    }
    void display() {
      System.out.println(temperature);
    }
  }

  @Test
  public void test() {
    WeatherData weatherData = new WeatherData();
    CurrentCondition currentCondition = new CurrentCondition(weatherData);
    weatherData.temperatureChange(20);

    weatherData.removeObserver(currentCondition);
    weatherData.temperatureChange(25);
  }

}
