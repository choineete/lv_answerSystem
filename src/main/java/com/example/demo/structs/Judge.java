package com.example.demo.structs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Judge {
    private Integer id;
    private String question;
    private String answer;
}
