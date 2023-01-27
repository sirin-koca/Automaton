public class FiniteAutomaton {
    private String[] states;
    private String[] alphabet;
    private String[][] transitionTable;
    private String startState;
    private String[] acceptStates;

    public FiniteAutomaton(String[] states, String[] alphabet, String[][] transitionTable, String startState, String[] acceptStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
        this.startState = startState;
        this.acceptStates = acceptStates;
    }

    public boolean checkString(String input) {
        String currentState = startState;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int index = -1;
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j].equals(Character.toString(c))) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                return false;
            }
            int stateIndex = -1;
            for (int j = 0; j < states.length; j++) {
                if (states[j].equals(currentState)) {
                    stateIndex = j;
                    break;
                }
            }
            currentState = transitionTable[stateIndex][index];
        }
        for (String acceptState : acceptStates) {
            if (acceptState.equals(currentState)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Define the states, alphabet, transition table, start state, and accept states
        String[] states = {"q1", "q2", "q3"};
        String[] alphabet = {"a", "b"};
        String[][] transitionTable = {{"q2", "q3"}, {"q3", "q2"}, {"q1", "q1"}};
        String startState = "q1";
        String[] acceptStates = {"q2"};

        // Create a finite automaton with the defined parameters
        FiniteAutomaton fa = new FiniteAutomaton(states, alphabet, transitionTable, startState, acceptStates);

        // Test some input strings
        System.out.println(fa.checkString("ab")); // should print true
        System.out.println(fa.checkString("baa")); // should print false
    }
}
