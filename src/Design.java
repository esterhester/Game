public class Design {
    public String getDesing(int numberStep){
        String desing = "";
        switch (numberStep) {
            case 0:
                desing = """
                           +---+
                           |   |
                               |
                               |
                               |
                               |
                        =========""";
                break;
            case 1:
                desing = """
                           +---+
                           |   |
                           O   |
                               |
                               |
                               |
                        =========""";
                break;
            case 2:
                desing = """
                           +---+
                           |   |
                           O   |
                           |   |
                               |
                               |
                        =========""";
                break;
            case 3:
                desing = """
                           +---+
                           |   |
                           O   |
                          /|   |
                               |
                               |
                        =========""";
                break;
            case 4:
                desing = """
                           +---+
                           |   |
                           O   |
                          /|\\  |
                               |
                               |
                        =========""";
                break;
            case 5:
                desing = """
                           +---+
                           |   |
                           O   |
                          /|\\  |
                          /    |
                               |
                        =========""";
                break;
            case 6:
                desing = """
                           +---+
                           |   |
                           O   |
                          /|\\  |
                          / \\  |
                               |
                        =========""";
                break;
            default:
                desing = null;
        }
        return desing;

    }
}
