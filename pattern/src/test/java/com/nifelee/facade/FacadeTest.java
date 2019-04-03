package com.nifelee.facade;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 어떤 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공
 * 퍼사드에서 고수준 인터페이스를 정의하기 때문에 서브시스템을 더 쉽게 사용할수 있음
 * 단순화된 인터페이스를 통해서 서브시스템을 더 쉽게 사용할 수 있도록 하기위한 용도
 *
 * 디자인 원칙
 * 최소 지식 원칙 : 정말 친한 친구하고만 얘기하라.
 *
 * ex) 홈시어터
 */
@Slf4j
public class FacadeTest {

  class Power {
    boolean powered = false;
    void powerOn() { powered = true; }
    void powerOff() { powered = false; }
  }

  class Tv extends Power {
    void watch() { powerOn(); log.debug("Watch tv."); }
  }

  class Radio extends Power {
    void listen() { powerOn(); log.debug("Listen radio."); }
  }

  class Lamp {
    int light = 0;
    void bright() { this.light = 10; }
    void dark() { this.light = 5; }
    void off() { this.light = 0; }
  }

  @AllArgsConstructor class HomeFacade {
    private Tv tv;
    private Radio radio;
    private Lamp lamp;
    void enjoyTv() {
      lamp.bright();
      radio.powerOff();
      tv.watch();
    }
    void enjoyRadio() {
      lamp.dark();
      tv.powerOff();
      radio.listen();
    }
    void goOut() {
      tv.powerOff();
      radio.powerOff();
      lamp.off();
    }
  }

  @Test
  public void home() {
    HomeFacade homeFacade = new HomeFacade(new Tv(), new Radio(), new Lamp());
    homeFacade.enjoyTv();
    homeFacade.enjoyRadio();
    homeFacade.goOut();
  }

}
