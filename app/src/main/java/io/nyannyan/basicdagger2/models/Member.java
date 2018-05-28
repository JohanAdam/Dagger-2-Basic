package io.nyannyan.basicdagger2.models;

public class Member {

  private String memberId;
  private String name;
  private String email;

  public Member(String id, String name, String email) {
    this.memberId = id;
    this.name = name;
    this.email = email;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
