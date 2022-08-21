package csen1002.main.task1;

/**
 * Write your info here
 *
 * @name Mohamed Abdelhamid
 * @id 43-1637
 * @labNumber 08
 */
import java.util.ArrayList;

public class DFA {
    public String description;
    public ArrayList<String> states = new ArrayList<String>();
    public DFA(String description) {
        this.description = description;
    }


    public boolean run(String input) {
        // TODO Write Your Code Here
        String temp = new String();
        String goal = new String();
        String results = new String();
        int index = 0;
        for (int i = 0; i < description.length(); i++) {
            if (description.charAt(i) == ';') {
                if (temp.length() < 4) {
                    temp = "" + description.charAt(i - 5) + "" + description.charAt(i - 3) + "" + description.charAt(i - 1);
                    states.add(temp);

                } else {
                    temp = new String();
                }
            }
            if (description.charAt(i) == '#') {
                temp = new String();
                temp = "" + description.charAt(i - 5) + "" + description.charAt(i - 3) + "" + description.charAt(i - 1);
                states.add(temp);

                index = i + 1;
            }
        }
        for (int i = index; i < description.length(); i++) {
            if (description.charAt(i) != ',') {
                goal = goal + description.charAt(i);
            }
        }
        results = results + description.charAt(0);
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < states.size(); j++) {


                if (results.charAt(count) == states.get(j).charAt(0)) {
                    if (input.charAt(i) == '0') {
                        results = results + states.get(j).charAt(1);
                        count = count + 1;
                    } else {
                        results = results + states.get(j).charAt(2);
                        count = count + 1;
                    }
                    break;

                }
            }
        }
        for (int i = 0; i < goal.length(); i++) {
            if (results.charAt(count) == goal.charAt(i)) {
                return true;
            }
        }

        return false;
    }
}
