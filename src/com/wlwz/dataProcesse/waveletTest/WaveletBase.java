package com.wlwz.dataProcesse.waveletTest;

/**
 * Created by yanzi on 2016/3/22.
 */
public abstract class WaveletBase {
    /**
     *
     Abstract function for calculating a waveletTest function.

     @param values
     Calculate the waveletTest function from the <tt>values</tt>
     array.
     */
    abstract public void wavelet_calc( double[] values );

    /**
     *
     Print the waveletTest function result.

     */
    abstract public void pr();

    abstract public void inverse();
}
