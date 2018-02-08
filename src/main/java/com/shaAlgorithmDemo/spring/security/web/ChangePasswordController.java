package com.shaAlgorithmDemo.spring.security.web;

import com.shaAlgorithmDemo.spring.security.model.User;
import com.shaAlgorithmDemo.spring.security.service.UserService;
import com.shaAlgorithmDemo.spring.security.web.dto.ChangePasswordDto;
import com.shaAlgorithmDemo.spring.security.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Laura on 2/8/2018
 */

@Controller
@RequestMapping("/changePassword")
public class ChangePasswordController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public ChangePasswordDto changePasswordDto() {
        return new ChangePasswordDto();
    }

    @PostMapping
    public String changePassword(@Valid ChangePasswordDto changePasswordDto,
                                      BindingResult result){

        UserDetails currentUser = userService.currentUserDetails();
        User user1 = userService.findByUsername(currentUser.getUsername());
        String currentPass = user1.getPassword();
        String encodedOldPass = userService.encodeString(changePasswordDto.getOldPassword());

        if (!currentPass.equals(encodedOldPass))
            result.rejectValue("oldPassword", null, "Incorrect Old Password");

        if (result.hasErrors()){
            return "changePassword";
        }

        User user = userService.findByUsername(currentUser.getUsername());
        user.setPassword(userService.encodeString(changePasswordDto.getNewPassword()));
        userService.save(user);
        return "redirect:/changePassword?success";
    }
}
