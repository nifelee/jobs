package com.nifelee.state;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 객체의 상태에 의하여 결정된 방법으로 객체를 동작하게 할 때 사용
 * 상태 객체를 따로 만들어 포함하게 하고, 상태 객체에게 위임하여 동작하게 함
 */
@Slf4j
public class StateTest {
  interface State {
    void doIt(Context context);
  }
  class Poor implements State {
    @Override public void doIt(Context context) { log.debug("poor.."); context.changeState(new Rich()); }
  }
  class Rich implements State {
    @Override public void doIt(Context context) { log.debug("rich.."); context.changeState(new Poor()); }
  }
  class Context {
    private State state;
    Context () { this.state = new Poor(); }
    void changeState(State state) { this.state = state; }
    void doIt() { state.doIt(this); }
  }

  @Test
  public void state() {
    Context context = new Context();
    context.doIt();
    context.doIt();
    context.doIt();
  }
}
