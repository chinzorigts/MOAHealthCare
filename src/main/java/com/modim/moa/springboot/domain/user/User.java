package com.modim.moa.springboot.domain.user;

import com.modim.moa.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity(name = "tbl_user")
public class User extends BaseTimeEntity implements Serializable {

    @Id
    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    @Column(length = 100)
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 100, message = "비밀번호는 2자 이상 100자 이하로 입력해주세요.")
    @Column(length = 100,nullable = false)
    private String pass;

    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Column(length = 50,nullable = false)
    private String name;

    @Column(length = 50,nullable = false)
    private String birthday;

    @Column(length = 50)
    private String sex;

    @Column(length = 3)
    private int height;

    @Column(precision = 4,scale = 1)
    private BigDecimal weight;

    @Column(length = 50)
    private String created_user_id;

    @Column(length = 50)
    private String modified_user_id;

    @Builder
    public User(String email, String pass, String name, String birthday, String sex, int height, BigDecimal weight, String created_user_id, String modified_user_id) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.created_user_id = created_user_id;
        this.modified_user_id = modified_user_id;
    }

    public void update(String email, String pass, String name, String birthday, String sex, int height, BigDecimal weight, String modifiedUserID) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.modified_user_id = modifiedUserID;
    }
}
