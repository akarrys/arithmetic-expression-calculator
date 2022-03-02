import java.util.Objects;

public class Main
{

    public static Result evaluateExpression(String expression)
    {
        ArrayStack opStk = new ArrayStack(); //stack for operators
        ArrayStack valStk = new ArrayStack(); //stack for values
        ArrayStack comparitorsStk = new ArrayStack(); //stack for binary operators
        ArrayStack bigopQue = new ArrayStack(); //relaional
        ArrayStack valuationQue = new ArrayStack(); //results
        Result myresult = new Result(0); //myresult ref object ro Result class
        String[] define = expression.split("\\s+"); //string array to displau results expression
        int valuetoCompare = 0;

        for (String s :define )
        {
            if (Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/"))
                opStk.push(s);
            else if(myresult.myComparator(s))
                comparitorsStk.push(s);
            else
                valStk.push(Integer.parseInt(s));
        }

        while(!valStk.isEmpty())
        {
            if(opStk.size() == 1 && !comparitorsStk.isEmpty())
            {
                String thistemp = valStk.pop().toString();
                valuetoCompare = Integer.parseInt(valStk.pop().toString());
                valStk.push(thistemp);
            }
            if (opStk.size() == 1)
            {
                if(myresult.e == 0)
                    myresult.e = Integer.parseInt(valStk.pop().toString());
                myresult = Result.runOp(opStk.pop().toString(), Integer.parseInt(valStk.pop().toString()), myresult);
            } else
            {
                String tempOp = opStk.pop().toString();
                int tempVal = Integer.parseInt(valStk.pop().toString());

                if (myresult.checkPrecedence(tempOp, opStk.top().toString()))
                {
                    bigopQue.push(opStk.pop());
                    myresult.e = tempVal;
                    myresult = Result.runOp(tempOp,Integer.parseInt(valStk.pop().toString()), myresult);
                    valuationQue.push(myresult.e);
                    myresult.e = 0;

                } else
                {
                    if(myresult.e == 0)
                        myresult.e = Integer.parseInt(valStk.pop().toString());
                    myresult = Result.runOp(opStk.pop().toString(), Integer.parseInt(valStk.pop().toString()), myresult);
                    bigopQue.push(tempOp);
                    valuationQue.push(tempVal);
                }

            }
            if(valStk.isEmpty() && !valuationQue.isEmpty())
            {
                while(!bigopQue.isEmpty())
                {
                    myresult = Result.runOp(bigopQue.pop().toString(), Integer.parseInt(valuationQue.pop().toString()), myresult);
                }
            }
        }

        if(!comparitorsStk.isEmpty())
        {
            myresult = Result.myCompare(comparitorsStk.pop().toString(), valuetoCompare, myresult);
        }

        return myresult;
    }

    public static void main(String[] args)
    {
        System.out.println("Artamis Karrys");
        Result sampleExp1 = evaluateExpression("250 <= 50 - 10 * 4 + 6");//custom tests
        Result sampleExp2 = evaluateExpression("14 >= 4 - 3 * 2 + 7"); //sampleExp in pdf
        Result sampleExp3 = evaluateExpression("5400 - 300 * 20 + 777"); //custom tests
        Result sampleExp4 = evaluateExpression("56322 == 56322 * 2"); //custom test
        Result sampleExp5 = evaluateExpression("5 != 6 + 0");
        Result sampleExp6 = evaluateExpression("5 > 0 + 5");
        Result sampleExp7 = evaluateExpression("2500 < 2500 / 5");

        //sampleExp1, used in above for Result ref
        if(Objects.equals(sampleExp1.component, "boolean"))
            System.out.println("<" + sampleExp1.component +  ", " + sampleExp1.george + ">");
        else
            System.out.println("<" + sampleExp1.component +  ", " + sampleExp1.e + ">");

        //sampleExp2, same as above and example used in project pdf
        if(Objects.equals(sampleExp2.component, "boolean"))
            System.out.println("<" + sampleExp2.component + ", " + sampleExp2.george + ">");
        else
            System.out.println("<" + sampleExp2.component + ", " +   sampleExp2.e + ">");

        //sampleExp3, same as above, Result ref
        if(Objects.equals(sampleExp3.component, "boolean"))
            System.out.println("<" + sampleExp3.component + ", " + sampleExp3.george + ">");
        else
            System.out.println("<" + sampleExp3.component + ", " +   sampleExp3.e + ">");


        if(Objects.equals(sampleExp4.component, "boolean"))
            System.out.println("<" + sampleExp4.component + ", " + sampleExp4.george + ">");
        else
            System.out.println("<" + sampleExp4.component + ", " +   sampleExp4.e + ">");

        if(Objects.equals(sampleExp5.component, "boolean"))
            System.out.println("<" + sampleExp5.component + ", " + sampleExp5.george + ">");
        else
            System.out.println("<" + sampleExp5.component + ", " +   sampleExp5.e + ">");

        if(Objects.equals(sampleExp6.component, "boolean"))
            System.out.println("<" + sampleExp6.component + ", " + sampleExp6.george + ">");
        else
            System.out.println("<" + sampleExp6.component + ", " +   sampleExp6.e + ">");

        if(Objects.equals(sampleExp7.component, "boolean"))
            System.out.println("<" + sampleExp7.component + ", " + sampleExp7.george + ">");
        else
            System.out.println("<" + sampleExp7.component + ", " +   sampleExp7.e + ">");


    }
}