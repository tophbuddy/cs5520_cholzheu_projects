package edu.neu.khoury.madsea.chrisholzheu;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ToDoItemContentConverter {

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static DateTimeFormatter localDateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static DateTimeFormatter isoDateTimeFormatter =
            DateTimeFormatter.ISO_DATE_TIME;

    @TypeConverter
    public static String convertSet(Set<String> todoTags) {
        return todoTags.toString();
    }

    @TypeConverter
    public static Set<String> convertString(String todoTags) {
        return Arrays.stream(todoTags.substring(1,todoTags.length()-1).split("\\s*,\\s*"))
                .collect(Collectors.toSet());
    }

    @TypeConverter
    public static LocalDateTime convertTimeStamp(Long value) {
        if (value == null) {
            return null;
        } else {
           LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochSecond(value),
                    ZoneOffset.UTC);
           return date;
        }
    }

    @TypeConverter
    public static Long convertDate(LocalDateTime localDateTime) {
        return localDateTime == null ? null : localDateTime.toEpochSecond(ZoneOffset.UTC);
//        return localDateTime == null ? null : localDateTime.format(isoDateTimeFormatter);
    }
}

//if (toDoId.getValue() == null)
//        return DEFAULT_ID;
//        else
//        return toDoId.getValue() + DEFAULT_ID;