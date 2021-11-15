package test;

import java.util.Collection;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	private final Collection<Operation> operations;
	
	public Calculator(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	public void calcurate(int lhs, int rhs, char op) {
		
		for(var operation: operations) {
			if(operation.handles(op)) {
				var result = operation.apply(lhs, rhs);
				System.out.printf("%d %s %d = %s%n", lhs, op, rhs, result);
				return;
			}
		}
		throw new IllegalArgumentException("Unknwon operation "+ op);
	}
}
