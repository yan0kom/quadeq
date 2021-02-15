package ru.yan0kom.quadeq.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.val;
import lombok.var;
import ru.yan0kom.quadeq.dao.EvalHistoryEntryDao;
import ru.yan0kom.quadeq.dto.EvalHistoryDto;
import ru.yan0kom.quadeq.dto.QuadraticEquationCoefficientsDto;
import ru.yan0kom.quadeq.dto.QuadraticEquationDto;
import ru.yan0kom.quadeq.model.EvalHistoryEntry;
import ru.yan0kom.quadeq.model.QuadraticEquation;

@Service
public class QuadraticEquationService {
	@Autowired
	EvalHistoryEntryDao evalHistoryEntryDao;

	// for test
	public QuadraticEquationDto evaluate(QuadraticEquationCoefficientsDto coeffs) {
		return evaluate(coeffs, false);
	}

	public QuadraticEquationDto evaluate(QuadraticEquationCoefficientsDto coeffs, boolean addEvalHistoryEntry) {
		double x1 = 0;
		double x2 = 0;
		int rootCount = 0;
		String error = null;

		if (coeffs.getA() == 0) {
			error = "Уравнение не является квадратным";
		} else if (coeffs.getB() == 0 && coeffs.getC() == 0) {
			x1 = 0;
			rootCount = 1;
		} else if (coeffs.getB() == 0) {
			val xx = -(coeffs.getC() / coeffs.getA());
			if (xx < 0) {
				rootCount = 0;
			} else {
				rootCount = 2;
				x1 = Math.sqrt(xx);
				x2 = -x1;
			}
		} else if (coeffs.getC() == 0) {
			rootCount = 2;
			x1 = 0;
			x2 = -(coeffs.getB() / coeffs.getA());
		} else {
			val d = Math.pow(coeffs.getB(), 2) - 4 * coeffs.getA() * coeffs.getC();
			if (d < 0) {
				rootCount = 0;
			} else if (d == 0) {
				rootCount = 1;
				x1 = (-coeffs.getB()) / (2 * coeffs.getA());
			} else if (d > 0) {
				val dsqrt = Math.sqrt(d);
				rootCount = 2;
				x1 = (-coeffs.getB() + dsqrt) / (2 * coeffs.getA());
				x2 = (-coeffs.getB() - dsqrt) / (2 * coeffs.getA());
			}
		}

		var quadEq = new QuadraticEquation(coeffs, x1, x2, rootCount, error);
		if (addEvalHistoryEntry) {
			quadEq = addEvalHistoryEntry(quadEq);
		}
		return QuadraticEquationDto.fromEntity(quadEq);
	}

	public QuadraticEquation addEvalHistoryEntry(QuadraticEquation quadEq) {
		val entry = new EvalHistoryEntry();
		entry.setTs(new Date());
		entry.setQuadEq(quadEq);
		return evalHistoryEntryDao.save(entry).getQuadEq();
	}

	public EvalHistoryDto getEvalHistory() {
		val sort = new Sort(Sort.Direction.DESC, "ts");
		return EvalHistoryDto.fromEntityList(evalHistoryEntryDao.findAll(sort));
	}
}
