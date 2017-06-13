package bitcamp.java93.domain;

public class Teacher extends Member {
  String homepage;
  String facebook;
  String twitter;
  
  @Override
  public String toString() {
    return "Teacher [homepage=" + homepage + ", facebook=" + facebook + ", twitter=" + twitter + ", no=" + no
        + ", name=" + name + ", tel=" + tel + ", email=" + email + ", password=" + password + "]";
  }
  
  public String getHomepage() {
    return homepage;
  }
  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }
  public String getFacebook() {
    return facebook;
  }
  public void setFacebook(String facebook) {
    this.facebook = facebook;
  }
  public String getTwitter() {
    return twitter;
  }
  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }
  
  
}
