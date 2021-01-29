package ru.yan0kom.quadeq.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.val;
import ru.yan0kom.quadeq.dto.QuadraticEquationCoefficientsDto;

public class QuadraticEquationCoefficientsArgResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return QuadraticEquationCoefficientsDto.class.equals(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		val pm = webRequest.getParameterMap();
		return new QuadraticEquationCoefficientsDto(
				Double.valueOf(pm.get("a")[0]),
				Double.valueOf(pm.get("b")[0]),
				Double.valueOf(pm.get("c")[0]));
	}

}
