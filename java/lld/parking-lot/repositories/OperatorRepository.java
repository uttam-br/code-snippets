package repositories;

import models.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorRepository {

    private final static Map<Integer, Operator> operatorMap = new HashMap<>();

    public void save(Operator operator) {
        if (operator.getOperatorId() == 0) {
            operator.setOperatorId(operatorMap.keySet().size() + 1);
        }
        operatorMap.put(operator.getOperatorId(), operator);
    }

    public Operator getById(int operatorId) throws Exception {
        if (!operatorMap.containsKey(operatorId)) {
            throw new Exception("Operator does not exists...");
        }
        return operatorMap.get(operatorId);
    }

}
