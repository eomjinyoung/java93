package step16;

import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStream {
  OutputStream out;
  
  public DataOutputStream(OutputStream out) {
    this.out = out;
  }
  
  public void writeByte(int b) throws IOException {
    out.write(b);
  }
  
  public void writeShort(int b) throws IOException {
    out.write(b >> 8);
    out.write(b);
  }
  
  public void writeInt(int b) throws IOException {
    out.write(b >> 24);
    out.write(b >> 16);
    out.write(b >> 8);
    out.write(b);
  }
  
  public void writeUTF(String str) throws IOException {
    byte[] bytes = str.getBytes("UTF-8");
    int len = bytes.length;
    out.write(len >> 8);
    out.write(len);
    out.write(bytes);
  }
  
  public void close() throws IOException {
    out.close();
  }
}
