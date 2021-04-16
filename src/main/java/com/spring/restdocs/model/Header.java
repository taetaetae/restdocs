package com.spring.restdocs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

  private String resultCode;
  private T data;

  //OK
  public static <T> Header<T> OK() {
    return (Header<T>) Header
        .builder()
        .resultCode("OK")
        .build();
  }

  //DATA OK
  public static <T> Header<T> OK(T data) {
    return (Header<T>) Header
        .builder()
        .resultCode("OK")
        .data(data)
        .build();
  }

  //Error
  public static <T> Header<T> ERROR() {
    return (Header<T>) Header
        .builder()
        .resultCode("ERROR")
        .build();
  }

}
