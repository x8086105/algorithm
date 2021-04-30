package com.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Native;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mom {

    private Integer age;

    private String name;


}
