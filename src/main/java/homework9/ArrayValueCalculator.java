package homework9;

public class ArrayValueCalculator {

    public int doCalc(String[][] inputArray) throws ArraySizeException, ArrayDataException {
        for (int i = 0; i < 4; i++) {
            if (inputArray[i].length != 4) {
                throw new ArraySizeException("Input array size should be 4X4 - 4 arrays must contain 4 elements each");
            }
        }
        int arraySum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                try {
                    arraySum += Integer.parseInt(inputArray[i][j]);
                } catch (NumberFormatException e) {
                    int firsIndexCorr = i + 1;
                    int secondIndexCorr = j + 1;
                    throw new ArrayDataException("Invalid data in cell (" + firsIndexCorr + "," + secondIndexCorr + "): " +
                            inputArray[i][j] + " - input must contain only numbers", e);
                }
            }
        }
        return arraySum;
    }

}
