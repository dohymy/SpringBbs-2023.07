package com.ys.sbbs.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok 사용법
// 아래의 어노테이션을 통해
// 기본 생성자, 모든 멤버변수 생성자, toString, getterSetter를 만듬
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Student {
	private int sid;
	private String name;
	private LocalDate regDate;
// source - constructor, getterSetter, toString를 사용하지 않아도 된다.
}
