import org.apache.commons.math3.special.Erf;

import java.text.DecimalFormat;

/**
 * Created by esteves on 28.04.15.
 */


public class Sample {

    public static void main(String[] args) {
        //testando funcao Z
        System.out.println(pToZ(.95));
        System.out.println(pToZ(.975));
        System.out.println(pToZ(.995));
        //http://www.pucrs.br/famat/rossana/psicologia/tabela_normal.pdf


        //estimando valor da amostra
        //nivel de confianca, intervalo de confianca, tamanho da populacao
        System.out.println(getSampleSize(0.95, 0.02, 10000));
    }

    private static double pToZ(double p) {
        p = 1.0 - p;
        DecimalFormat decimal = new DecimalFormat( "0.00" );
        return Double.parseDouble(decimal.format(Math.sqrt(2) * Erf.erfcInv(2 * p)));
    }

    private static long getSampleSize(double confidenceLevel, double confidenceInterval, long populationSize) {
        double Z = pToZ(confidenceLevel);
        double aux = (Math.pow(Z, 2) * 0.5 * (1 - 0.5)) / Math.pow(confidenceInterval, 2);
        double sampleSize = aux  / (1 + (aux - 1) / populationSize);
        return Math.round(sampleSize);
    }

}
