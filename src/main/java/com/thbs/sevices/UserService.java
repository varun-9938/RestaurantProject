package com.thbs.sevices;

import com.thbs.model.Customer;
import com.thbs.model.Users;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Priyanka_Ramesh,
 */


public interface UserService
{
    public String signin(HttpServletRequest request, Customer cust);
    public String login(@ModelAttribute("user") Users u1);
}
