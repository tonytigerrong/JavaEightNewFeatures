package com.eight.optional;

import java.util.Optional;

public class Demo {

	public static void main(String[] args) {
		String realName = "Tony";
		String nullName = null;
		Optional<String> strOpt1 = Optional.of(realName);
		// Optional<String> nullOpt1 = Optional.of(nullName); // will throw
		// exception, since .of can't take null
		Optional<String> strOpt2 = Optional.ofNullable(nullName);
		System.out.println(strOpt1.get());
		System.out.println(strOpt1.map(String::toUpperCase).get());

		Optional<Optional<String>> multiOpt1 = Optional.of(Optional.of(realName));
		System.out.println(
				multiOpt1
					.flatMap(
							m -> m.map(String::toUpperCase)
							)
					.get()
				);
		//ifPresent isPresent
		System.out.println("isPresent of strOpt1:"+strOpt1.isPresent());
		System.out.println("isPresent of strOpt2:"+strOpt2.isPresent());
		
		strOpt1.ifPresent(System.out::println);
		strOpt2.ifPresent(System.out::println); // no excution since strOpt2 is null optional
		
		//orElse
		System.out.println("strOpt1.orElse(\"N/A\"):"+strOpt1.orElse("N/A"));
		System.out.println("strOpt2.orElse(\"N/A\"):"+strOpt2.orElse("N/A"));
	}
}
