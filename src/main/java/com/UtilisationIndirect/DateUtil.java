package com.UtilisationIndirect;//utilisé pour retourner la date in Order (facture)

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    // Date yraj3o string
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    // Date ya3tih pattern
    public static String getCurrentDate() {
        return formatDate(new Date(), "yyyy-MM-dd");
    }

    // Time ya3tih pattern
    public static String getCurrentTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }
}
