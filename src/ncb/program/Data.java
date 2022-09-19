/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ncb.program;

import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * @author Malik Heron
 */
@Entity
@Table(name = "data", catalog = "users", schema = "")
@NamedQueries({
        @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
        @NamedQuery(name = "Data.findById", query = "SELECT d FROM Data d WHERE d.id = :id"),
        @NamedQuery(name = "Data.findByFirst", query = "SELECT d FROM Data d WHERE d.first = :first"),
        @NamedQuery(name = "Data.findByLast", query = "SELECT d FROM Data d WHERE d.last = :last"),
        @NamedQuery(name = "Data.findByAge", query = "SELECT d FROM Data d WHERE d.age = :age"),
        @NamedQuery(name = "Data.findByGender", query = "SELECT d FROM Data d WHERE d.gender = :gender"),
        @NamedQuery(name = "Data.findByParish", query = "SELECT d FROM Data d WHERE d.parish = :parish"),
        @NamedQuery(name = "Data.findByEmail", query = "SELECT d FROM Data d WHERE d.email = :email"),
        @NamedQuery(name = "Data.findByUsername", query = "SELECT d FROM Data d WHERE d.username = :username"),
        @NamedQuery(name = "Data.findByPassword", query = "SELECT d FROM Data d WHERE d.password = :password"),
        @NamedQuery(name = "Data.findByAccountNumber", query = "SELECT d FROM Data d WHERE d.accountNumber = :accountNumber"),
        @NamedQuery(name = "Data.findByBalance", query = "SELECT d FROM Data d WHERE d.balance = :balance"),
        @NamedQuery(name = "Data.findBytime", query = "SELECT d FROM Data d WHERE d.time = :time")})

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first")
    private String first;
    @Column(name = "last")
    private String last;
    @Column(name = "age")
    private String age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "parish")
    private String parish;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "account_number")
    private String accountNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Float balance;
    @Column(name = "time")
    private String time;
    @Column(name = "AccessTime")
    private String AccessTime;

    public Data() {
    }

    public Data(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        String oldFirst = this.first;
        this.first = first;
        changeSupport.firePropertyChange("first", oldFirst, first);
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        String oldLast = this.last;
        this.last = last;
        changeSupport.firePropertyChange("last", oldLast, last);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        String oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        String oldParish = this.parish;
        this.parish = parish;
        changeSupport.firePropertyChange("parish", oldParish, parish);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        String oldAccountNumber = this.accountNumber;
        this.accountNumber = accountNumber;
        changeSupport.firePropertyChange("accountNumber", oldAccountNumber, accountNumber);
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        Float oldBalance = this.balance;
        this.balance = balance;
        changeSupport.firePropertyChange("balance", oldBalance, balance);
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        String oldtime = this.time;
        this.username = time;
        changeSupport.firePropertyChange("time", oldtime, time);
    }

    public String getAccessTime() {
        return AccessTime;
    }

    public void setAccessTime(String accessTime) {
        String oldAccessTime = this.AccessTime;
        this.username = AccessTime;
        changeSupport.firePropertyChange("AccessTime", oldAccessTime, AccessTime);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "ncb.program.Data[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}