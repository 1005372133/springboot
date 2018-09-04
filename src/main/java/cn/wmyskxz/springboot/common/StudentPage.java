package cn.wmyskxz.springboot.common;

public class StudentPage extends BasePage {
    private String id;
    private String idOperator = "=";
    private String pwd;
    private String pwdOperator = "=";
    private String username;
    private String usernameOperator = "=";
    private String age;
    private String ageOperator = "=";
    private String sex;
    private String sexOperator = "=";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwdOperator() {
        return pwdOperator;
    }

    public void setPwdOperator(String pwdOperator) {
        this.pwdOperator = pwdOperator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameOperator() {
        return usernameOperator;
    }

    public void setUsernameOperator(String usernameOperator) {
        this.usernameOperator = usernameOperator;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeOperator() {
        return ageOperator;
    }

    public void setAgeOperator(String ageOperator) {
        this.ageOperator = ageOperator;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexOperator() {
        return sexOperator;
    }

    public void setSexOperator(String sexOperator) {
        this.sexOperator = sexOperator;
    }
}
