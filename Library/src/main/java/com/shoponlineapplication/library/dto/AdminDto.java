package com.shoponlineapplication.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    @Size(min = 3,max =10,message = "invalid first name!(3-10 character)")
    private String firstName;

    @Size(min = 3,max =10,message = "invalid last name!(3-10 character)")
    private String lastName;

    private String username;
    @Size(min = 5,max =15,message = "invalid password!(5-15 character)")

    private String password;
    private String repeatPassword;
}
