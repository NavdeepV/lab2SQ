package com.ontariotechu.sofe3980U;

public class BinaryAPIResult {
    private String operand1;
    private String operator;
    private String operand2;
    private Result result;
    public BinaryAPIResult(Binary operand1, String operator, Binary operand2, Binary result) {
        this.operand1 = operand1.getValue();
        this.operator = operator;
        this.operand2 = operand2.getValue();
        this.result = new Result(result.getValue());
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperand2() {
        return operand2;
    }

    public Result getResult() {
        return result;
    }

    public static class Result {
        private String results;

        public Result(String results) {
            this.results = results;
        }

        public String getValue() {
            return results;
        }

        public void setValue(String results) {
            this.results = results;
        }
    }
}