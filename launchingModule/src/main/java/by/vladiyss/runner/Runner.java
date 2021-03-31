package by.vladiyss.runner;

import by.vladiyss.presentation.LoggingAndRecursiveBinarySearchPresentation;

import java.util.Scanner;

public class Runner {

    private static final String END_STRING = "exit";

    private String arrayElementsCount;
    private String keyToFind;

    private String endConditionNotification() {
        System.out.println("Enter 'exit' to end or something to continue");
        Scanner scanner = new Scanner(System.in);
        //tempString = scanner.nextLine();
        return scanner.nextLine();
    }

    private void processStringValuesInput() {
        System.out.println("Enter the number of array elements(array elements start with 0)");
        Scanner scanner = new Scanner(System.in);
        arrayElementsCount = scanner.nextLine();

        System.out.println("Enter key to find in array");
        scanner = new Scanner(System.in);
        keyToFind = scanner.nextLine();
    }

    private void callRecursiveBinarySearch(
            LoggingAndRecursiveBinarySearchPresentation binarySearchPresenter, Runner runner) {
        binarySearchPresenter.setExploredArrayElementsCount(Integer.parseInt(runner.arrayElementsCount));
        binarySearchPresenter.setKeyToFind(Integer.parseInt(runner.keyToFind));
        binarySearchPresenter.runSearch();
    }

    public static void main(String[] args) {

        LoggingAndRecursiveBinarySearchPresentation binarySearchPresenter =
                new LoggingAndRecursiveBinarySearchPresentation();

        Runner runner = new Runner();
        runner.processStringValuesInput();

        runner.callRecursiveBinarySearch(binarySearchPresenter, runner);

        String tempString;
        tempString = runner.endConditionNotification();

        while(!tempString.equals(END_STRING)) {
            runner.processStringValuesInput();
            runner.callRecursiveBinarySearch(binarySearchPresenter, runner);
            tempString = runner.endConditionNotification();
        }
    }
}
