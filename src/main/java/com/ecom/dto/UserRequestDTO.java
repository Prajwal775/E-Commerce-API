package com.ecom.dto;

import com.ecom.Enumeration.RoleType;
import lombok.Data;

@Data
public class UserRequestDTO {
    String username;
    String password;
    String email;
    RoleType role; // optional, can default to USER
}
