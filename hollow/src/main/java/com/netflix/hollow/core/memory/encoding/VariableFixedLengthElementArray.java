package com.netflix.hollow.core.memory.encoding;

import com.netflix.hollow.core.memory.pool.ArraySegmentRecycler;

public class VariableFixedLengthElementArray extends FixedLengthElementArray {
    private int ptr;
    private final int capacity;
    public VariableFixedLengthElementArray(ArraySegmentRecycler memoryRecycler, int size) {
        super(memoryRecycler, (long)29*size);
        this.ptr = 0;
        this.capacity = size*29;
    }

    public void addElementValue(int value) {
        setElementValue(ptr, 29, value);
        ptr += 29;
    }

    public int size() {
        return ptr/29;
    }

    public boolean isFull() {
        return ptr == capacity;
    }

    public int getElementValue(int index) {
        return (int)getElementValue(index, 29);
    }
}
