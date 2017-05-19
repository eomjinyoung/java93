package step16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyDataInputStream extends FileInputStream {
  public MyDataInputStream(String name) throws FileNotFoundException {
    super(name);
  }
  
  public byte readByte() throws IOException {
    return (byte)this.read();
  }
  
  public short readShort() throws IOException {
    short temp;
    temp = (short)(this.read() << 8);
    temp |= (short)this.read();
    return temp;
  }
  
  public int readInt() throws IOException {
    int temp;
    temp = this.read() << 24;
    temp |= this.read() << 16;
    temp |= this.read() << 8;
    temp |= this.read();
    return temp;
  }
  
  
  
  
}
