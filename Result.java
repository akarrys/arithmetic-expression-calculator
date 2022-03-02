public class Result {
    int e;
    boolean george;
    String component; //same as string type

    public Result(int g) {
        e = g;
        component = "integer";
    }

    public Result(boolean g) {
        george = g;
        component = "boolean";
    }

    public static Result myCompare(String op, int val, Result myresult) {
        boolean iresult;
        switch (op) {
            case ">":
                return new Result(val > myresult.e);
            case "<":
                return new Result(val < myresult.e);
            case ">=":
                return new Result(val >= myresult.e);
            case "<=":
                return new Result(val <= myresult.e);
            case "==":
                return new Result(val == myresult.e);
            case "!=":
                return new Result(val != myresult.e);
            default:
                return new Result(false);
        }
    }

    public static Result runOp(String op, int val, Result myresult) {
        return switch (op) {
            case "+" -> new Result(val + myresult.e);
            case "-" -> new Result(val - myresult.e);
            case "*" -> new Result(val * myresult.e);
            case "/" -> new Result(val / myresult.e);
            default -> new Result(0);
        };
    }

    public boolean myComparator(String op1) {
        boolean isresult = switch (op1) {
            case ">", "<", ">=", "<=", "==", "!=" -> true;
            default -> false;
        };
        return isresult;
    }

    public boolean checkPrecedence(String op1, String op2) {
        if (op1.contentEquals("-"))
            return !op2.contentEquals("*") && !op2.contentEquals("/");
        if (op1.contentEquals("+"))
            return !op2.contentEquals("/") && !op2.contentEquals("*");
        else
            return true;
    }
}



