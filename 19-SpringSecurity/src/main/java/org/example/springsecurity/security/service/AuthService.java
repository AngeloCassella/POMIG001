package org.example.springsecurity.security.service;

import org.example.springsecurity.security.payload.LoginDto;
import org.example.springsecurity.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
