package by.vladiyss.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAndRecursiveBinarySearchPresentation {

    private static final Logger logger = LoggerFactory
            .getLogger(LoggingAndRecursiveBinarySearchPresentation.class);

    private static int nestingLevelOfSearchCounter = 0;
    private int keyToFind;
    private int[] exploredArray;


    private void freeExploredArray() {
        exploredArray = null;
    }

    public void setKeyToFind(int key) {
        keyToFind = key;
    }

    public void setExploredArrayElementsCount(int arrayElementsCount) {
        exploredArray = new int[arrayElementsCount];
        for (int i = 0; i != arrayElementsCount; ++i) {
            exploredArray[i] = i;
        }
    }

    public void runSearch() {
        logger.debug("The recursive binary search is about to start");

        int resultKeyIndex =
                recursiveBinarySearch(exploredArray, keyToFind, 0, exploredArray.length - 1);

        logger.debug("The recursive binary search ended");
        if (resultKeyIndex == -1) {
            logger.debug("Key {} is not presented in this array!", keyToFind);
        }
        else {
            logger.debug("Key {} has a position {} in this array", keyToFind, resultKeyIndex);
        }

        logger.debug("==============================================================================");
        freeExploredArray();
        nestingLevelOfSearchCounter = 0;
    }

    private int recursiveBinarySearch(int[] exploredArray, int key, int lowerBound, int upperBound) {
        logger.debug("Nesting level - {}", nestingLevelOfSearchCounter++);
        logger.debug("Lower and upper bounds - {} - {}", lowerBound, upperBound);

        if ( (lowerBound < exploredArray.length - 1) && (upperBound >= lowerBound) ) {

            int middleIndex = lowerBound + (upperBound - lowerBound) / 2;

            if (exploredArray[middleIndex] == key) {
                return middleIndex;
            }

            if (exploredArray[middleIndex] > key) {
                return recursiveBinarySearch(exploredArray, key, lowerBound, middleIndex - 1);
            }

            return recursiveBinarySearch(exploredArray, key, middleIndex + 1, upperBound);
        }

        if ( (lowerBound == upperBound) && (lowerBound == exploredArray.length - 1) ) {
            return lowerBound;
        }
        return -1;
    }
}
