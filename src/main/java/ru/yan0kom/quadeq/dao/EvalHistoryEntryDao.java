package ru.yan0kom.quadeq.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.yan0kom.quadeq.model.EvalHistoryEntry;

@Repository
public interface EvalHistoryEntryDao extends JpaRepository<EvalHistoryEntry, Long> {
	@Override
	List<EvalHistoryEntry> findAll(Sort sort);
}
