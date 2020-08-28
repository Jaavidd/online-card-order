package onlinecardorder.util;

import org.apache.commons.lang3.StringUtils;

public class DataFieldFormatter {

    public static String formatPhone(String phone) {
        if (StringUtils.isBlank(phone)) return "";
        phone = phone.replaceAll(" ", "");
        phone = phone.replaceAll("-", "");
        if (!phone.startsWith("994")) {
            if (phone.startsWith("0")) {
                return "994" + phone.substring(1);
            }
            return "994" + phone;
        }
        return phone;
    }

    public static String formatPhoneWithoutCountryCode(String phone) {
        return formatPhone(phone).replace("994", "");
    }

    public static String formatPan(String pan) {
        if (pan.length() > 8) {
            return pan.substring(8);
        }
        return pan;
    }

}
