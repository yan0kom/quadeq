package ru.yan0kom.quadeq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.yan0kom.quadeq.dao.EvalHistoryEntryDao;

@Configuration
@ComponentScan({"ru.yan0kom.quadeq.service"})
public class TestConfig {
	@Bean
	public EvalHistoryEntryDao getEvalHistoryEntryDao() {
		return null;
	}
}
