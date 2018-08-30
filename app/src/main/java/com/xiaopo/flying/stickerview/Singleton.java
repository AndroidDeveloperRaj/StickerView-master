package com.xiaopo.flying.stickerview;

/**
 * Created by 2125 on 3/15/2018.
 */

public class Singleton {
  private static Singleton sIngleTon;
    Singleton()
    {

    }
    public static synchronized Singleton getInstance() {
        if (sIngleTon == null) {
            sIngleTon = new Singleton();
        }
        return(sIngleTon);
    }
}
