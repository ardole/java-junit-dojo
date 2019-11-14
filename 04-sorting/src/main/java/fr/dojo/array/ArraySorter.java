package fr.dojo.array;

class ArraySorter {

    int[] bubbleSort(int[] arrayIn) {
        boolean sorted = false;
        int arrayLength = arrayIn.length;
        while ( ! sorted ) {
            sorted = true;
            for (int i = 0 ; i < arrayLength - 1; i++) {
                if (arrayIn[i] > arrayIn[i + 1]) {
                    int temp = arrayIn[i + 1] ;
                    arrayIn[i + 1] = arrayIn[i];
                    arrayIn[i] = temp;
                    sorted = false;
                }
            }
            arrayLength--;
        }
        return arrayIn;
    }

    int[] insertionSort(int[] arrayIn) {
        for (int i = 1; i < arrayIn.length; i++) {
            processInsertion(arrayIn[i], arrayIn, i);
        }
        return arrayIn;
    }

    private void processInsertion(int toInsert, int arrayIn[], int shiftLeft) {
        int i;
        for (i = shiftLeft; i > 0 && arrayIn[i-1] > toInsert; i--) {
            arrayIn[i] = arrayIn[i-1];
        }
        arrayIn[i] = toInsert;
    }

    int[] selectionSort(int[] arrayIn) {
        int length = arrayIn.length - 1;
        while (length > 0) {
            int maxIndex  = 0;
            for (int i = 1; i <= length; i++) {
                if (arrayIn[i] > arrayIn[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(arrayIn, maxIndex, length);
            length--;
        }
        return arrayIn;
    }

    private void swap(int[] arrayIn, int y, int z) {
        int temp = arrayIn[y];
        arrayIn[y] = arrayIn[z];
        arrayIn[z] = temp;
    }

}
