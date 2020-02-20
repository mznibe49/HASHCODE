public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        operations.parseInput(args[0]);
        

        // System.out.println(operations);

        operations.setAllRatios();
        operations.sortLibraries();
        
        operations.subFile(operations.libraries);

        // System.out.println(operations);
    }
}
