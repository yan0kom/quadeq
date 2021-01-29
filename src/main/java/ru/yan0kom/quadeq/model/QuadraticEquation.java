package ru.yan0kom.quadeq.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yan0kom.quadeq.dto.QuadraticEquationCoefficientsDto;

@Embeddable
@Data
@NoArgsConstructor
public class QuadraticEquation {
	@Column(name = "coeff_a", nullable = false)
	private Double a;

	@Column(name = "coeff_b", nullable = false)
	private Double b;

	@Column(name = "coeff_c", nullable = false)
	private Double c;

	@Column(name = "root_count", nullable = false)
	private int rootCount;

	@Column(name = "root_1")
	private Double x1;

	@Column(name = "root_2")
	private Double x2;

	@Column(name = "eval_error", length = 1000)
	private String error;

	public QuadraticEquation(QuadraticEquationCoefficientsDto coeffs, double x1, double x2, int rootCount, String error) {
		this.a = coeffs.getA();
		this.b = coeffs.getB();
		this.c = coeffs.getC();
		this.x1 = x1;
		this.x2 = x2;
		this.rootCount = rootCount;
		this.error = error;
	}
}
