package pama1234.game.app.server.server0001.game.net.data;

import pama1234.game.app.server.server0001.game.ServerPlayerCenter3D;
import pama1234.game.app.server.server0001.game.net.SocketData;
import pama1234.game.app.server.server0001.game.net.io.ServerRead;
import pama1234.game.app.server.server0001.game.net.io.ServerWrite;
import pama1234.game.app.server.server0001.game.particle.CellGroup3D;
import pama1234.util.wrapper.Center;

public class Server0001Core{
  public Center<SocketData> socketCenter;
  public Center<ServerRead> serverReadPool;
  public Center<ServerWrite> serverWritePool;
  //---
  public CellGroup3D group;
  public ServerPlayerCenter3D playerCenter;
  public Server0001Core(Center<SocketData> socketCenter,Center<ServerRead> serverReadPool,Center<ServerWrite> serverWritePool,CellGroup3D group,ServerPlayerCenter3D playerCenter) {
    this.socketCenter=socketCenter;
    this.serverReadPool=serverReadPool;
    this.serverWritePool=serverWritePool;
    this.group=group;
    this.playerCenter=playerCenter;
  }
  public void sleep(long in) {
    try {
      Thread.sleep(in);
    }catch(InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException(e);//TODO
    }
  }
}
