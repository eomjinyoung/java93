package humor;

public class Greet2 {
  String pre;
  String post;
  
  
  public String getPre() {
    return pre;
  }


  public void setPre(String pre) {
    this.pre = pre;
  }


  public String getPost() {
    return post;
  }


  public void setPost(String post) {
    this.post = post;
  }


  public void print(String message) {
    if (this.pre != null)
      System.out.println(pre);
    System.out.println(message);
    if (this.post != null)
    System.out.println(post);
  }
}
