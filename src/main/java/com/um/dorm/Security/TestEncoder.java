package com.um.dorm.Security;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestEncoder {
    // public static void main(String[] args) {
    //     String password = "1234";
    //     PasswordEncoder encoder = passwordEncoder();
    //     String hashedPassword = encoder.encode(password);
    //     System.out.println("Contraseña codificada: " + hashedPassword);
    // }

    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
