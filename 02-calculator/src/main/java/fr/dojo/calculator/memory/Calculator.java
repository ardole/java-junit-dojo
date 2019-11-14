package fr.dojo.calculator.memory;

class Calculator {

    private long memory = 0;

    long add(int x, int y) {
        return saveAndReturn(x + y);
    }

    private long saveAndReturn(long res) {
        this.memory = res;
        return res;
    }

    long substract (int x, int y) {
        return saveAndReturn(x - y);
    }

    long multiply (int x, int y) {
        return saveAndReturn(x * y);
    }

    long divide (int x, int y) {
        return saveAndReturn(x / y);
    }

    long getMemory() {
        return this.memory;
    }

    void cleanMemory() {
        this.memory = 0;
    }

}
