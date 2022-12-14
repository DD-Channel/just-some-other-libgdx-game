package pama1234.gdx.game.ui.util;

import pama1234.gdx.game.util.function.ExecuteF;
import pama1234.gdx.game.util.function.GetBoolean;
import pama1234.gdx.util.app.UtilScreen;
import pama1234.gdx.util.entity.Entity;
import pama1234.gdx.util.info.TouchInfo;

public abstract class Button extends Entity<UtilScreen>{
  public GetBoolean active;
  public TouchInfo touch;
  public ExecuteF press,clickStart,clickEnd;
  public Button(UtilScreen p,GetBoolean active,ExecuteF press,ExecuteF clickStart,ExecuteF clickEnd) {
    super(p);
    this.active=active;
    this.press=press;
    this.clickStart=clickStart;
    this.clickEnd=clickEnd;
  }
  // @Override
  // public void display() {}
  @Override
  public void update() {
    if(touch!=null) press();
  }
  public abstract boolean inButton(float x,float y);
  public boolean active() {
    return active.get();
  }
  public void press() {
    if(active()) press.execute();
  }
  public void clickStart() {
    if(active()) clickStart.execute();
  }
  public void clickEnd() {
    if(active()) clickEnd.execute();
  }
  @Override
  public void touchStarted(TouchInfo info) {
    if(inButton(info.osx,info.osy)) {
      touch=info;
      clickStart();
    }
  }
  @Override
  public void touchEnded(TouchInfo info) {
    if(touch==info) {
      touch=null;
      clickEnd();
    }else if(inButton(info.osx,info.osy)&&inButton(info.ox,info.oy)) clickEnd();
  }
}