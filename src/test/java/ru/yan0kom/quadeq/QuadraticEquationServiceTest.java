package ru.yan0kom.quadeq;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.val;
import ru.yan0kom.quadeq.dto.QuadraticEquationCoefficientsDto;
import ru.yan0kom.quadeq.service.QuadraticEquationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class QuadraticEquationServiceTest {
	@Autowired
	private QuadraticEquationService quadraticEquationService;

	@Test
	public void when_A_eq0_then_Error() {
		val coeffs = new QuadraticEquationCoefficientsDto(0, 5, 10);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertNotNull(eq.getError());
	}

	@Test
	public void when_D_lt0_then_NoRoots() {
		val coeffs = new QuadraticEquationCoefficientsDto(5, 3, 7);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertEquals(0, eq.getRootCount());
	}

	@Test
	public void when_D_eq0_then_1Root() {
		val coeffs = new QuadraticEquationCoefficientsDto(1, 12, 36);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertEquals(1, eq.getRootCount());
		assertEquals(-6, eq.getX1(), 0);
	}

	@Test
	public void when_D_gt0_then_2Roots() {
		val coeffs = new QuadraticEquationCoefficientsDto(1, -2, -3);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertEquals(2, eq.getRootCount());
		assertEquals(3, eq.getX1(), 0);
		assertEquals(-1, eq.getX2(), 0);
	}

	@Test
	public void when_BC_eq0_then_1Root_eq0() {
		val coeffs = new QuadraticEquationCoefficientsDto(15, 0, 0);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertEquals(1, eq.getRootCount());
		assertEquals(0, eq.getX1(), 0);
	}

	@Test
	public void when_B_eq0_And_CdivA_lt0_then_2Roots() {
		val coeffs = new QuadraticEquationCoefficientsDto(4, 0, -16);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertEquals(2, eq.getRootCount());
		assertEquals(2, eq.getX1(), 0);
		assertEquals(-2, eq.getX2(), 0);
	}

	@Test
	public void when_B_eq0_And_CdivA_gt0_then_NoRoots() {
		val coeffs = new QuadraticEquationCoefficientsDto(-4, 0, -16);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertEquals(0, eq.getRootCount());
	}

	@Test
	public void when_C_eq0_And_CdivA_lt0_then_2Roots() {
		val coeffs = new QuadraticEquationCoefficientsDto(4, 0, -16);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertEquals(2, eq.getRootCount());
		assertEquals(2, eq.getX1(), 0);
		assertEquals(-2, eq.getX2(), 0);
	}

	@Test
	public void when_C_eq0_then_2Roots_x1_eq0() {
		val coeffs = new QuadraticEquationCoefficientsDto(1, -7, 0);
		val eq = quadraticEquationService.evaluate(coeffs);
		assertEquals(2, eq.getRootCount());
		assertEquals(0, eq.getX1(), 0);
		assertEquals(7, eq.getX2(), 0);
	}

}
