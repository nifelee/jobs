package com.nifelee.template;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 전반적인 구현은 상위클래스(주로 Abstract로 만듦)에서 담당하고 부분적인 곳의 구체적인 구현은 하위클래스가 담당
 * ex) servlet : doGet/doPost
 */
@Slf4j
public class TemplateTest {
  abstract class Worker {
    abstract void doIt();
    void work() {
      log.debug("출근");
      doIt();
      log.debug("퇴근");
    }
  }
  class Designer extends Worker {
    @Override
    void doIt() { log.debug("Design"); }
  }
  class Programmer extends Worker {
    @Override
    void doIt() { log.debug("Coding"); }
  }

  @Test
  public void template() {
    Worker designer = new Designer();
    designer.work();
    Worker programmer = new Programmer();
    programmer.work();
  }
}
