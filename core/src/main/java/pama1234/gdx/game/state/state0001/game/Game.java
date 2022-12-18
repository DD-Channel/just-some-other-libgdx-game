package pama1234.gdx.game.state.state0001.game;

import static com.badlogic.gdx.Input.Keys.ESCAPE;

import pama1234.gdx.game.app.Screen0011;
import pama1234.gdx.game.state.state0001.State0001;
import pama1234.gdx.game.state.state0001.StateGenerator0001.StateEntity0001;
import pama1234.gdx.game.state.state0001.game.player.MainPlayer2D;
import pama1234.gdx.game.state.state0001.game.region.Block;
import pama1234.gdx.game.state.state0001.game.world.World;
import pama1234.gdx.game.state.state0001.game.world.World0001;
import pama1234.gdx.game.state.state0001.game.world.WorldCenter;
import pama1234.gdx.game.ui.ButtonGenerator;
import pama1234.gdx.game.ui.util.Button;
import pama1234.gdx.util.listener.EntityListener;
import pama1234.math.Tools;

public class Game extends StateEntity0001{
  public Button<?>[] buttons;
  public float time;
  //---
  public World0001 world;
  public WorldCenter<Screen0011,Game,World<Screen0011,Game>> worldCenter;
  public EntityListener displayCamTop;
  public Game(Screen0011 p) {
    super(p);
    buttons=ButtonGenerator.genButtons_0005(p);
    worldCenter=new WorldCenter<Screen0011,Game,World<Screen0011,Game>>(p);
    worldCenter.list.add(world=new World0001(p,this));
    worldCenter.pointer=0;
    displayCamTop=new EntityListener() {
      @Override
      public void display() {
        // p.beginBlend();
        // p.image(ImageAsset.background,-288,-162);
        // p.imageBatch.flush();
        // p.endBlend();
        MainPlayer2D tp=world.yourself;
        int bx=tp.blockX();
        int by=tp.blockY();
        // Block block=tp.getBlock(bx,by),
        //   blockLeft=tp.getBlock(bx-1,by),
        //   blockRight=tp.getBlock(bx+1,by);
        p.fill(94,193,255);
        p.rect(tp.xInt(),tp.yInt(),4,4);
        p.fill(94,203,234,200);
        // p.rect(bx*world.blockWidth,by*world.blockHeight,4,4);
        // p.rect((bx+1)*world.blockWidth,by*world.blockHeight,4,4);
        // p.rect((bx-1)*world.blockWidth,by*world.blockHeight,4,4);
        if(Tools.moveInRange(tp.x(),0,world.blockWidth)>tp.w/2f) {
          p.rect((bx)*world.blockWidth,by*world.blockHeight,4,4);
          p.rect((bx+1)*world.blockWidth,by*world.blockHeight,4,4);
        }else if(Tools.moveInRange(tp.x(),0,world.blockWidth)<world.blockWidth/2f) {
          p.rect((bx-1)*world.blockWidth,by*world.blockHeight,4,4);
          p.rect((bx)*world.blockWidth,by*world.blockHeight,4,4);
        }else {
          p.rect(bx*world.blockWidth,by*world.blockHeight,4,4);
          p.rect((bx+1)*world.blockWidth,by*world.blockHeight,4,4);
          p.rect((bx-1)*world.blockWidth,by*world.blockHeight,4,4);
        }
      }
    };
  }
  @Override
  public void init() {
    p.backgroundColor(191);
    p.cam.noGrab();
    // tvgRefresh();
    for(Button<?> e:buttons) p.centerScreen.add.add(e);
    worldCenter.init();
    p.centerCam.add.add(displayCamTop);
    p.centerCam.add.add(worldCenter);
  }
  @Override
  public void dispose() {
    for(Button<?> e:buttons) p.centerScreen.remove.add(e);
    p.centerCam.remove.add(worldCenter);
    worldCenter.dispose();
    p.centerCam.remove.add(displayCamTop);
  }
  @Override
  public void displayCam() {
    worldCenter.displayCam();
  }
  @Override
  public void display() {
    // Block block=world.regions.getBlock(UtilMath.floor(p.mouse.x/world.blockHeight),UtilMath.floor(p.mouse.y/world.blockWidth));
    // p.text(block==null?"null":block.type.name,p.width/2,p.height/2);
    MainPlayer2D tp=world.yourself;
    p.text(tp.x()+" "+tp.y()+" "+tp.groundLevel,p.width/2,p.height/2);
    // Block block=world.regions.getBlock(UtilMath.floor(world.yourself.xInt()/world.blockHeight),UtilMath.floor(world.yourself.yInt()/world.blockWidth));
    Block block=tp.getBlock(tp.blockX(),tp.blockY());
    p.text(block==null?"null":block.type.name,p.width/2,p.height/2+p.bu);
  }
  @Override
  public void update() {
    time+=p.frameRate;
  }
  @Override
  public void frameResized(int w,int h) {}
  @Override
  public void keyReleased(char key,int keyCode) {
    if(keyCode==ESCAPE) p.state(State0001.StartMenu);
  }
}