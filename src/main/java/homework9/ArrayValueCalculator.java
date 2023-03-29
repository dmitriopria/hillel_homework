package homework9;

public class ArrayValueCalculator {

    public int doCalc(String[][] inputArray) {
        if (isMatrixSizeCorrect(inputArray)) {
            throw new ArraySizeException("Input array size should be 4X4 - 4 arrays must contain 4 elements each");
        }
        int arraySum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                try {
                    arraySum += Integer.parseInt(inputArray[i][j]);
                } catch (NumberFormatException e) {
                    int firsIndex = i + 1;
                    int secondIndex = j + 1;
                    throw new ArrayDataException("Invalid data in cell (" + firsIndex + "," + secondIndex + "): " +
                            inputArray[i][j] + " - all array cells must be only numbers");
                }
            }
        }
        return arraySum;
    }

    private boolean isMatrixSizeCorrect(String[][] inputArray) {
        return inputArray.length != 4 ||
                inputArray[0].length != 4 ||
                inputArray[1].length != 4 ||
                inputArray[2].length != 4 ||
                inputArray[3].length != 4;
    }
}
