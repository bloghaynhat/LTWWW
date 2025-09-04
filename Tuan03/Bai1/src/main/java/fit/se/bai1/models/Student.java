package fit.se.bai1.models;

import java.time.LocalDate;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private List<String> hobbies;
    private String classXBoard;
    private String classXPercentage;
    private String classXYearOfPassing;
    private String classXIIBoard;
    private String classXIIPercentage;
    private String classXIIYearOfPassing;

    private String gradutionBoard;
    private String gradutionPercentage;
    private String gradutionYearOfPassing;

    private String mastersBoard;
    private String mastersPercentage;
    private String mastersYearOfPassing;

    private int courseApply;

    public Student(String firstName, String lastName, String birthday, String email, String phone, String gender, String address, String city, String pinCode, String state, String country, List<String> hobbies, String classXBoard, String classXPercentage, String classXYearOfPassing, String classXIIBoard, String classXIIPercentage, String classXIIYearOfPassing, String gradutionBoard, String gradutionPercentage, String gradutionYearOfPassing, String mastersBoard, String mastersPercentage, String mastersYearOfPassing, int courseApply) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.classXBoard = classXBoard;
        this.classXPercentage = classXPercentage;
        this.classXYearOfPassing = classXYearOfPassing;
        this.classXIIBoard = classXIIBoard;
        this.classXIIPercentage = classXIIPercentage;
        this.classXIIYearOfPassing = classXIIYearOfPassing;
        this.gradutionBoard = gradutionBoard;
        this.gradutionPercentage = gradutionPercentage;
        this.gradutionYearOfPassing = gradutionYearOfPassing;
        this.mastersBoard = mastersBoard;
        this.mastersPercentage = mastersPercentage;
        this.mastersYearOfPassing = mastersYearOfPassing;
        this.courseApply = courseApply;
    }

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getClassXBoard() {
        return classXBoard;
    }

    public void setClassXBoard(String classXBoard) {
        this.classXBoard = classXBoard;
    }

    public String getClassXPercentage() {
        return classXPercentage;
    }

    public void setClassXPercentage(String classXPercentage) {
        this.classXPercentage = classXPercentage;
    }

    public String getClassXYearOfPassing() {
        return classXYearOfPassing;
    }

    public void setClassXYearOfPassing(String classXYearOfPassing) {
        this.classXYearOfPassing = classXYearOfPassing;
    }

    public String getClassXIIBoard() {
        return classXIIBoard;
    }

    public void setClassXIIBoard(String classXIIBoard) {
        this.classXIIBoard = classXIIBoard;
    }

    public String getClassXIIPercentage() {
        return classXIIPercentage;
    }

    public void setClassXIIPercentage(String classXIIPercentage) {
        this.classXIIPercentage = classXIIPercentage;
    }

    public String getClassXIIYearOfPassing() {
        return classXIIYearOfPassing;
    }

    public void setClassXIIYearOfPassing(String classXIIYearOfPassing) {
        this.classXIIYearOfPassing = classXIIYearOfPassing;
    }

    public String getGradutionBoard() {
        return gradutionBoard;
    }

    public void setGradutionBoard(String gradutionBoard) {
        this.gradutionBoard = gradutionBoard;
    }

    public String getGradutionPercentage() {
        return gradutionPercentage;
    }

    public void setGradutionPercentage(String gradutionPercentage) {
        this.gradutionPercentage = gradutionPercentage;
    }

    public String getGradutionYearOfPassing() {
        return gradutionYearOfPassing;
    }

    public void setGradutionYearOfPassing(String gradutionYearOfPassing) {
        this.gradutionYearOfPassing = gradutionYearOfPassing;
    }

    public String getMastersBoard() {
        return mastersBoard;
    }

    public void setMastersBoard(String mastersBoard) {
        this.mastersBoard = mastersBoard;
    }

    public String getMastersPercentage() {
        return mastersPercentage;
    }

    public void setMastersPercentage(String mastersPercentage) {
        this.mastersPercentage = mastersPercentage;
    }

    public String getMastersYearOfPassing() {
        return mastersYearOfPassing;
    }

    public void setMastersYearOfPassing(String mastersYearOfPassing) {
        this.mastersYearOfPassing = mastersYearOfPassing;
    }

    public int getCourseApply() {
        return courseApply;
    }

    public void setCourseApply(int courseApply) {
        this.courseApply = courseApply;
    }
}
