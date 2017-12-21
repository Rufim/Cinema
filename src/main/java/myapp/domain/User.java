package myapp.domain;

import biz.source_code.base64Coder.Base64Coder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "mydb")
@EqualsAndHashCode
@Data
@Component
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column
    private Integer idUser;

    @Basic(optional = false)
    @Column
    private String email;

    @Basic(optional = false)
    @Column
    private String password;

    @Basic(optional = false)
    @Column
    private String fname;

    @Basic(optional = false)
    @Column
    private String lname;

    @Basic(optional = false)
    @Column
    private char gender;

    @Column
    private Integer birthDay;

    @Column
    private Integer birthMonth;

    @Basic(optional=false)
    @Column
    private int birthYear;
    @Column
    private String languages;

    @Column
    private String aboutYou;

    @Column
    private String hobby;

    @Lob
    @Column
    private byte[] photo;

    public User() {
    }

    public String getPhotoBase64() {
        return this.photo != null ? new String(Base64Coder.encode(this.photo)) : new String("");
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String email, String password, String fname, String lname, char gender, int birthYear) {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.birthYear = birthYear;
    }

}
