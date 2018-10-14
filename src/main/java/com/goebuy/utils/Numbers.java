package com.goebuy.utils;

import com.google.common.base.Strings;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by luodejin on 2018/9/18.
 */
public class Numbers {
    private Numbers() {
    }

    public static double getFromatDouble(double value, int scale) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        return bigDecimal.setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static long safeParseLong(@Nullable String s, int defaultVal) {
        if(Strings.isNullOrEmpty(s)) {
            return (long)defaultVal;
        } else {
            try {
                return Long.parseLong(s);
            } catch (NumberFormatException var3) {
                return (long)defaultVal;
            }
        }
    }

    public static int safeParseInt(@Nullable String s, int defaultVal) {
        if(Strings.isNullOrEmpty(s)) {
            return defaultVal;
        } else {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException var3) {
                return defaultVal;
            }
        }
    }

    public static int safeParseInt(@Nullable String s) {
        return safeParseInt(s, 0);
    }

    public static double safeParseDouble(@Nullable String s, double defaultVal) {
        if(Strings.isNullOrEmpty(s)) {
            return defaultVal;
        } else {
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException var4) {
                return defaultVal;
            }
        }
    }

    public static double safeParseDouble(@Nullable String s) {
        return safeParseDouble(s, 0.0D);
    }

    public static float safeParseFloat(@Nullable String s, float defaultVal) {
        if(Strings.isNullOrEmpty(s)) {
            return defaultVal;
        } else {
            try {
                return Float.parseFloat(s);
            } catch (NumberFormatException var3) {
                return defaultVal;
            }
        }
    }

    public static float safeParseFloat(@Nullable String s) {
        return safeParseFloat(s, 0.0F);
    }
}

