package ru.netology.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationByCardInfo {
    private String fullName;
    private String phoneNumber;
}
