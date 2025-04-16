package com.ecom.dto;

import com.ecom.Enumeration.RoleType;
import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDTO {
    UUID id;
    String username;
    String email;
    RoleType role;
}
