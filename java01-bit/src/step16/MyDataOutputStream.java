package step16;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyDataOutputStream extends FileOutputStream {

  public MyDataOutputStream(String name) throws FileNotFoundException {
    super(name);
  }
  
  public void writeByte(int b) throws IOException {
    this.write(b);
  }
  
  public void writeShort(int b) throws IOException {
    this.write(b >> 8);
    this.write(b);
  }
  
  public void writeInt(int b) throws IOException {
    this.write(b >> 24);
    this.write(b >> 16);
    this.write(b >> 8);
    this.write(b);
  }
  
  public void writeUTF(String str) throws IOException {
    byte[] bytes = str.getBytes("UTF-8");
    int len = bytes.length;
    this.write(len >> 8);
    this.write(len);
    this.write(bytes);
  }
}
