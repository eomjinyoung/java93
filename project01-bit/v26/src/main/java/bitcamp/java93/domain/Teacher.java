package bitcamp.java93.domain;

import java.util.List;

public class Teacher extends Member {
  String homepage;
  String facebook;
  String twitter;
  List<String> photoList;
  
  @Override
  public String toString() {
    return "Teacher [homepage=" + homepage + ", facebook=" + facebook + ", twitter=" + twitter + ", photoList="
        + photoList + ", no=" + no + ", name=" + name + ", tel=" + tel + ", email=" + email + ", password=" + password
        + "]";
  }

  public List<String> getPhotoList() {
    return photoList;
  }
  public void setPhotoList(List<String> photoList) {
    this.photoList = photoList;
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
