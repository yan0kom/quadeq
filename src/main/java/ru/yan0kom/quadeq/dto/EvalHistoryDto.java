package ru.yan0kom.quadeq.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Value;
import lombok.val;
import ru.yan0kom.quadeq.model.EvalHistoryEntry;

@Value
public class EvalHistoryDto {

	@Value
	public static class EvalHistoryEntryDto {
		Date ts;
		QuadraticEquationDto quadEq;

		public static EvalHistoryEntryDto fromEntity(EvalHistoryEntry entity) {
			return new EvalHistoryEntryDto(entity.getTs(), QuadraticEquationDto.fromEntity(entity.getQuadEq()));
		}
	}

	List<EvalHistoryEntryDto> entries;

	public static EvalHistoryDto fromEntityList(List<EvalHistoryEntry> entitylist) {
		List<EvalHistoryEntryDto> entries = new ArrayList<EvalHistoryEntryDto>(entitylist.size());
		for (val entity : entitylist) {
			entries.add(EvalHistoryEntryDto.fromEntity(entity));
		}
		return new EvalHistoryDto(entries);
	}
}
