package com.nifelee.command;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 요구사항을 객체로 캡슐화 할 수 있으며, 매개변수를 써서 여러 가지 다른 요구 사항을 집어넣을수 있다.
 * 또한 요청 내역을 스택에 저장하거나 로그로 기록할수 도있으며 작업취소 기능도 지원가능 하다.
 * ex) Copy/Cut/Paste
 */
@Slf4j
public class CommandTest {

  interface Command {
    void redo();
    void undo();
  }

  class CommandImpl implements Command {
    private final String oldColor, newColor;
    private final Color color;
    CommandImpl(Color color, String str) {
      this.color = color;
      this.oldColor = this.color.getColor();
      this.newColor = str;
    }
    @Override
    public void redo() { color.setColor(newColor);}
    @Override
    public void undo() { color.setColor(oldColor); }
  }

  @AllArgsConstructor class Color {
    @Getter private String color;
    void setColor(String color) {
      log.debug("{} -> {}", this.color, color);
      this.color = color;
    }
  }

  class CommandManager {
    int index = 0;
    List<Command> commands = new ArrayList<>();

    void execute(Command command) {
      for (int i=commands.size()-1; i>index; i--)
        commands.remove(i);
      commands.add(command);
      redo();
    }
    void redo() { commands.get(index++).redo(); }
    void undo() { commands.get(--index).undo(); }
  }

  @Test
  public void command() {
    Color color = new Color("white");
    CommandManager commandManager = new CommandManager();
    commandManager.execute(new CommandImpl(color, "black"));
    commandManager.execute(new CommandImpl(color, "red"));
    commandManager.execute(new CommandImpl(color, "blue"));
    commandManager.undo();
    commandManager.undo();
    commandManager.redo();
    commandManager.undo();
    commandManager.undo();
  }

}
