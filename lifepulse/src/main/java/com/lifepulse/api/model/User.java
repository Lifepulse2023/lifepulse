package com.lifepulse.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_registration")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column
    @Size(min = 3, max = 50,message = "FirstName Required")
    private String firstName;
    @Column
    @Size(min = 3, max = 50,message = "LastName Required")
    private String lastName;
    @Column
    @Email(message = "Email Required")
    @NotBlank
    private String email;
    @Column
    private String password;
    @Column
    private boolean status;
    @Column
    private boolean verificationStatus;
    @Column
    private boolean newsLetter;
    @Column
    @AssertTrue
    private boolean termsAndCondition;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date created_timestamp;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date updated_timestamp;

}
