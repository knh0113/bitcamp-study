package bitcamp.myapp.vo;

public class Member {
  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  public int getNo() {
    return this.no;
  }

  public int setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return this.name;
  }

  public String setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public String setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public String setPassword(String password) {
    this.password = password;
  }

  public String getGender() {
    return this.gender;
  }

  public char setGender(String gender) {
    this.gender = gender;
  }

}