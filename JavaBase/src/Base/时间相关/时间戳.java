package Base.时间相关;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class 时间戳 {
    public static void main(String[] args) {
        //当前13位时间戳(毫秒)
        System.out.println((int) System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        //当前10位时间戳(秒)
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(new Date().getTime() / 1000);
        System.out.println(Calendar.getInstance().getTimeInMillis() / 1000);
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
    }
}
