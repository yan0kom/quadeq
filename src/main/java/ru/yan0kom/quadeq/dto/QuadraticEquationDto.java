package ru.yan0kom.quadeq.dto;

import lombok.Value;
import ru.yan0kom.quadeq.model.QuadraticEquation;

@Value
public class QuadraticEquationDto {
	double a;
	double b;
	double c;
	Double x1;
	Double x2;
	int rootCount;
	String error;

	public static QuadraticEquationDto fromEntity(QuadraticEquation entity) {
		return new QuadraticEquationDto(
				entity.getA(),
				entity.getB(),
				entity.getC(),
				entity.getX1(),
				entity.getX2(),
				entity.getRootCount(),
				entity.getError());
	}
}
