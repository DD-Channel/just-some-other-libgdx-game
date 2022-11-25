package pama1234.gdx.game.net;

import java.io.IOException;

import pama1234.data.ByteUtil;

public class NetUtil{
  public static byte[] readNBytes(SocketData e,byte[] out,int offset,int size) throws IOException {
    int ti=0;
    while(ti==0) ti=e.i.readNBytes(out,offset,size);
    if(ti!=size) throw new RuntimeException("ti!=size "+ti+" "+size);
    return out;
  }
  public static void writeHeader(SocketData e,byte[] outData,int state,int size) throws IOException {
    e.o.write(ByteUtil.intToByte(state,outData,0),0,4);
    e.o.write(ByteUtil.intToByte(size,outData,0),0,4);
    e.o.flush();
  }
  public static void writeHeader(SocketData e,byte[] outData,int size) throws IOException {
    writeHeader(e,outData,e.state,4);
  }
}