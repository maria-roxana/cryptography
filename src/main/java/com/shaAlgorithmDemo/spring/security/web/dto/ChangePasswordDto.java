package com.shaAlgorithmDemo.spring.security.web.dto;

import com.shaAlgorithmDemo.spring.security.constraint.FieldMatch;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Laura on 2/7/2018
 */

@FieldMatch.List({
        @FieldMatch(first = "newPassword", second = "confirmPassword", message = "The password fields must match"),
})
public class ChangePasswordDto {

    @NotEmpty
    private String oldPassword;

    @NotEmpty
    private String newPassword;

    @NotEmpty
    private String confirmPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
