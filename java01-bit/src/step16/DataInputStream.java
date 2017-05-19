package step16;

import java.io.IOException;
import java.io.InputStream;

public class DataInputStream {
  InputStream in;
  
  public DataInputStream(InputStream in) {
    this.in = in;
  }
  
  public byte readByte() throws IOException {
    return (byte)in.read();
  }
  
  public short readShort() throws IOException {
    short temp;
    temp = (short)(in.read() << 8);
    temp |= (short)in.read();
    return temp;
  }
  
  public int readInt() throws IOException {
    int temp;
    temp = in.read() << 24;
    temp |= in.read() << 16;
    temp |= in.read() << 8;
    temp |= in.read();
    return temp;
  }
  
  public String readUTF() throws IOException {
    int len;
    len = in.read() << 8;
    len |= in.read();
    
    byte[] buf = new byte[len];
    in.read(buf);
    
    return new String(buf, "UTF-8");
  }
  
  public void close() throws IOException {
    in.close();
  }
  
  
}
