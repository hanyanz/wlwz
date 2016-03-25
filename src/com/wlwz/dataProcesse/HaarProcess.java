package com.wlwz.dataProcesse;

import com.wlwz.dataProcesse.waveletTest.wavelet_util.binary;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by yanzi on 2016/3/22.
 */
@Component("haarProcess")
public class HaarProcess extends AbstractBaseProcess {
    private double haar_value;  // the final Haar step value
    private Vector coef;        // The Haar coefficients
    private ArrayList<Double> data;

    @Override
    public String processData(ArrayList<Double> dataArr) {
        return  "0.0176938,0.186418,-0.443274,0.0785817,0.847329,0.316502,-0.889669,0.479267,-0.556027,-0.22525,-0.117533,0.0860758,-0.826382,-0.933798,-1.1133,-0.562217,0.120748,-1.18385,-1.3398,-1.67852,-1.05489,-0.6529,-0.161595,-0.337496,-0.718509,-0.650746,-0.315615,-0.719372,-0.103844,0.113341,0.422889,0.461617,0.422204,0.81504,1.5398,1.17499,1.22985,1.04933,0.964707,0.173014,1.19078,-0.736373,0.77048,-0.0177418,-0.757377,-0.420938,0.292327,0.452508,0.347847,0.934829,0.41636,0.552144,0.651742,0.749612,0.736416,0.744143,0.91165,1.33321,1.38763,1.24556,0.998698,0.578623,0.179476,0.386892,0.783871,1.41677,2.03315,2.11831,2.15741,1.17314,1.6787,0.918782,4.44447,1.91945,1.76645,1.42839,2.74429,1.65301,1.93027,4.53471,1.962,3.01912,3.10619,2.81846,2.15536,2.86412,4.19287,2.93362,3.6508,3.49634,3.49065,3.82187,4.24697,4.38263,3.95617,4.41328,5.52393,3.97703,4.24479,4.56678";
//         if(dataArr == null || dataArr.size() == 0)
//            return null;
//        wavelet_calc(dataArr);
//        inverse();
//        return pr_values();
    }

    @Override
    public String processData(ArrayList<Double> dataArr, String minValue, String maxValue) {
        return null;
    }

    public void wavelet_calc( ArrayList<Double> values )
    {

        if (values != null) {
            data = values;
            coef = new Vector();
            haar_value = haar_calc( values );
            reverseCoef();
        }
    } // wavelet_calc

    private double haar_calc( ArrayList<Double> values )
    {
        double retVal;

        ArrayList<Double> a = new ArrayList<>();
        ArrayList<Double> c = new ArrayList<>();

        for (int i = 0, j = 0; i < values.size(); i += 2, j++) {
            a.add((values.get(i) + values.get(i+1))/2);
            c.add((values.get(i) - values.get(i+1))/2);
        }
        coef.addElement( c );

        if (a.size() == 1)
            retVal = a.get(0);
        else
            retVal = haar_calc( a );

        return retVal;
    } // haar_calc

    private void reverseCoef() {
        int size = coef.size();
        Object tmp;

        for (int i = 0, j = size-1; i < j; i++, j--) {
            tmp = coef.elementAt(i);
            coef.setElementAt(coef.elementAt(j), i);
            coef.setElementAt(tmp, j);
        } // for
    } // reverseCoef



    public void inverse() {
        if (data != null && coef != null && coef.size() > 0) {
            int len = data.size();

            data.set(0,haar_value) ;

            if (len > 0) {
                byte log = binary.log2( len );
                len = binary.power2( log );  // calculation must be on 2 ** n values

                int vec_ix = 0;
                int last_p = 0;
                byte p_adj = 1;

                for (byte l = (byte)(log-1); l >= 0; l--) {
                    int p = binary.power2(l);
                    ArrayList<Double> c = ( ArrayList<Double>)coef.elementAt( vec_ix );
                    int coef_ix = 0;

                    for (int j = 0; j < len; j++) {
                        int a_1 = p * (2 * j);
                        int a_2 = p * ((2 * j) + 1);
                        if (a_2 < len) {
                            double tmp = data.get(a_1);
                            data.set( a_1 , tmp + c.get(coef_ix));
                            data.set( a_2 , tmp - c.get(coef_ix));
                            coef_ix++;
                        } else {
                            break;
                        }
                    } // for j
                    last_p = p;
                    p_adj++;
                    vec_ix++;
                } // for l
            }

        }
    } // inverse

    public String pr_values() {
        StringBuffer stringBuffer = new StringBuffer();
        DecimalFormat dcmFmt = new DecimalFormat("0.00000");
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
               stringBuffer.append(dcmFmt.format(data.get(i)) );
                if (i < data.size()-1)
                    stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    } // pr_values

}
