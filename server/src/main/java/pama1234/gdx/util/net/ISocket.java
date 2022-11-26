package pama1234.gdx.util.net;

import java.io.InputStream;
import java.io.OutputStream;

public interface ISocket{
  public boolean isConnected();
  public InputStream getInputStream();
  public OutputStream getOutputStream();
  public String getRemoteAddress();
}
